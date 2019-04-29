package com.sinovatio.service;

import com.sinovatio.domain.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
* @ClassName: GenConfigService
* @Description: 代码生成配置服务
* @Author JinLu
* @Date 2019/4/19 14:26
* @Version 1.0
*/
@CacheConfig(cacheNames = "genConfig")
public interface GenConfigService {

    /**
     * find
     * @return
     */
    @Cacheable(key = "'1'")
    GenConfig find();

    /**
     * update
     * @param genConfig
     */
    @CachePut(key = "'1'")
    GenConfig update(GenConfig genConfig);
}
