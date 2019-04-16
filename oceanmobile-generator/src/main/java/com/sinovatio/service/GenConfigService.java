package com.sinovatio.service;

import com.sinovatio.domain.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**  
* @ClassName: GenConfigService
* @Description: 代码生成配置服务
* @Author JinLu
* @Date 2019/4/3 14:01
* @Version 1.0
*/
@CacheConfig(cacheNames = "genConfig")
public interface GenConfigService {

    /**
     * @Author JinLu
     * @Description:  配置信息查询
     * @Return com.sinovatio.domain.GenConfig
     * @Date 2019/4/3 14:37
    */
    @Cacheable(key = "'1'")
    GenConfig find();

    /**
     * @Author JinLu
     * @Description: 配置信息更新
     * @param genConfig
     * @Return com.sinovatio.domain.GenConfig
     * @Date 2019/4/3 14:38
    */
    @CachePut(key = "'1'")
    GenConfig update(GenConfig genConfig);
}
