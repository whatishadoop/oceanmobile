package com.sinovatio.service;

import com.sinovatio.domain.FileConfig;
import com.sinovatio.domain.FileContent;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.multipart.MultipartFile;

/**
* @ClassName: FileService
* @Description: 文件云服务
* @Author JinLu
* @Date 2019/4/19 16:17
* @Version 1.0
*/
@CacheConfig(cacheNames = "file")
public interface FileService {

    /**
     * 查配置
     * @return
     */
    @Cacheable(cacheNames = "fileConfig", key = "'1'")
    FileConfig find();

    /**
     * 修改配置
     * @param fileConfig
     * @return
     */
    @CachePut(cacheNames = "fileConfig", key = "'1'")
    FileConfig update(FileConfig fileConfig);

    /**
     * 上传文件
     * @param file
     * @param fileConfig
     */
    @CacheEvict(allEntries = true)
     FileContent upload(MultipartFile file, FileConfig fileConfig);

    /**
     * 查询文件
     * @param id
     * @return
     */
    @Cacheable(key = "'content:'+#p0")
    FileContent findByContentId(Long id);

    /**
     * 下载文件
     * @param content
     * @param config
     * @return
     */
    String download(FileContent content, FileConfig config);

    /**
     * 删除文件
     * @param content
     * @param config
     * @return
     */
    @CacheEvict(allEntries = true)
    void delete(FileContent content, FileConfig config);

    /**
     * 同步数据
     * @param config
     */
    @CacheEvict(allEntries = true)
    void synchronize(FileConfig config);

    /**
     * 删除文件
     * @param ids
     * @return
     */
    @CacheEvict(allEntries = true)
    void deleteAll(Long[] ids, FileConfig config);
}
