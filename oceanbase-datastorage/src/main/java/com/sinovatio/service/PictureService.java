package com.sinovatio.service;

import com.sinovatio.domain.Picture;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.multipart.MultipartFile;

/**
* @ClassName: PictureService
* @Description: 图片服务
* @Author JinLu
* @Date 2019/4/19 16:17
* @Version 1.0
*/
@CacheConfig(cacheNames = "picture")
public interface PictureService {

    /**
     * 上传图片
     * @param file
     * @param username
     * @return
     */
    @CacheEvict(allEntries = true)
    Picture upload(MultipartFile file, String username);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    Picture findById(Long id);

    /**
     * 删除图片
     * @param picture
     */
    @CacheEvict(allEntries = true)
    void delete(Picture picture);

    /**
     * 删除图片
     * @param ids
     */
    @CacheEvict(allEntries = true)
    void deleteAll(Long[] ids);
}
