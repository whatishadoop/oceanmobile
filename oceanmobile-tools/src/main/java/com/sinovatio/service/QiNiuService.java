package com.sinovatio.service;

import com.sinovatio.domain.QiniuConfig;
import com.sinovatio.domain.QiniuContent;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.multipart.MultipartFile;

/**
* @ClassName: QiNiuService
* @Description: 七牛云服务
* @Author JinLu
* @Date 2019/4/19 16:17
* @Version 1.0
*/
@CacheConfig(cacheNames = "qiNiu")
public interface QiNiuService {

    /**
     * 查配置
     * @return
     */
    @Cacheable(key = "'1'")
    QiniuConfig find();

    /**
     * 修改配置
     * @param qiniuConfig
     * @return
     */
    @CachePut(key = "'1'")
    QiniuConfig update(QiniuConfig qiniuConfig);

    /**
     * 上传文件
     * @param file
     * @param qiniuConfig
     */
    @CacheEvict(allEntries = true)
    QiniuContent upload(MultipartFile file, QiniuConfig qiniuConfig);

    /**
     * 查询文件
     * @param id
     * @return
     */
    @Cacheable(key = "'content:'+#p0")
    QiniuContent findByContentId(Long id);

    /**
     * 下载文件
     * @param content
     * @param config
     * @return
     */
    String download(QiniuContent content, QiniuConfig config);

    /**
     * 删除文件
     * @param content
     * @param config
     * @return
     */
    @CacheEvict(allEntries = true)
    void delete(QiniuContent content, QiniuConfig config);

    /**
     * 同步数据
     * @param config
     */
    @CacheEvict(allEntries = true)
    void synchronize(QiniuConfig config);
}
