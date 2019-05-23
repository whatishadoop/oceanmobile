package com.sinovatio.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.sinovatio.domain.FileConfig;
import com.sinovatio.domain.FileContent;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.repository.FileConfigRepository;
import com.sinovatio.repository.FileContentRepository;
import com.sinovatio.service.FileService;
import com.sinovatio.util.FilesUtil;
import com.sinovatio.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**  
* @ClassName: 文件云存储服务
* @Description: TODO
* @Author JinLu
* @Date 2019/4/19 16:18
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FileServiceImpl implements FileService {

    @Autowired
    private FileConfigRepository fileConfigRepository;

    @Autowired
    private FileContentRepository fileContentRepository;

    @Value("${file.max-size}")
    private Long maxSize;

    private final String TYPE = "公开";

    @Override
    public FileConfig find() {
        Optional<FileConfig> qiniuConfig = fileConfigRepository.findById(1L);
        if(qiniuConfig.isPresent()){
            return qiniuConfig.get();
        } else {
            return new FileConfig();
        }
    }

    // 更新操作需要设置事物@Transactional
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileConfig update(FileConfig fileConfig) {
        if (!(fileConfig.getHost().toLowerCase().startsWith("http://")|| fileConfig.getHost().toLowerCase().startsWith("https://"))) {
            throw new BadRequestException("外链域名必须以http://或者https://开头");
        }
        fileConfig.setId(1L);
        return fileConfigRepository.save(fileConfig);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileContent upload(MultipartFile file, FileConfig fileConfig) {

        Long size = maxSize * 1024 * 1024;
        if(file.getSize() > size){
            throw new BadRequestException("文件超出规定大小");
        }
        if(fileConfig.getId() == null){
            throw new BadRequestException("请先添加相应配置，再操作");
        }
        /**
         * 构造一个带指定Zone对象的配置类
         */
        Configuration cfg = FilesUtil.getConfiguration(fileConfig.getZone());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(fileConfig.getAccessKey(), fileConfig.getSecretKey());
        String upToken = auth.uploadToken(fileConfig.getBucket());
        try {
            String key = file.getOriginalFilename();
            if(fileContentRepository.findByKey(key) != null) {
                key = FilesUtil.getKey(key);
            }
            Response response = uploadManager.put(file.getBytes(), key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //存入数据库
            FileContent fileContent = new FileContent();
            fileContent.setBucket(fileConfig.getBucket());
            fileContent.setType(fileConfig.getType());
            fileContent.setKey(putRet.key);
            fileContent.setUrl(fileConfig.getHost()+"/"+putRet.key);
            fileContent.setSize(com.sinovatio.utils.FileUtil.getSize(Integer.parseInt(file.getSize()+"")));
            return fileContentRepository.save(fileContent);
        } catch (Exception e) {
           throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public FileContent findByContentId(Long id) {
        Optional<FileContent> qiniuContent = fileContentRepository.findById(id);
        ValidationUtil.isNull(qiniuContent,"FileContent", "id",id);
        return qiniuContent.get();
    }

    @Override
    public String download(FileContent content, FileConfig config){
        String finalUrl = null;
        if(TYPE.equals(content.getType())){
            finalUrl  = content.getUrl();
        } else {
            Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
            /**
             * 1小时，可以自定义链接过期时间
             */
            long expireInSeconds = 3600;
            finalUrl = auth.privateDownloadUrl(content.getUrl(), expireInSeconds);
        }
        return finalUrl;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(FileContent content, FileConfig config) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = FilesUtil.getConfiguration(config.getZone());
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(content.getBucket(), content.getKey());
            fileContentRepository.delete(content);
        } catch (QiniuException ex) {
            fileContentRepository.delete(content);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void synchronize(FileConfig config) {
        if(config.getId() == null){
            throw new BadRequestException("请先添加相应配置，再操作");
        }
        //构造一个带指定Zone对象的配置类
        Configuration cfg = FilesUtil.getConfiguration(config.getZone());
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(config.getBucket(), prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileContent fileContent = null;
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                if(fileContentRepository.findByKey(item.key) == null){
                    fileContent = new FileContent();
                    fileContent.setSize(com.sinovatio.utils.FileUtil.getSize(Integer.parseInt(item.fsize+"")));
                    fileContent.setKey(item.key);
                    fileContent.setType(config.getType());
                    fileContent.setBucket(config.getBucket());
                    fileContent.setUrl(config.getHost()+"/"+item.key);
                    fileContentRepository.save(fileContent);
                }
            }
        }

    }

    @Override
    public void deleteAll(Long[] ids, FileConfig config) {
        for (Long id : ids) {
            delete(findByContentId(id), config);
        }
    }
}
