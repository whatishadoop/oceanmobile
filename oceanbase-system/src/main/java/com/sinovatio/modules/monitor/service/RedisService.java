package com.sinovatio.modules.monitor.service;

import com.sinovatio.modules.monitor.domain.vo.RedisVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* @ClassName: RedisService
* @Description: 缓存服务接口
* @Author JinLu
* @Date 2019/4/19 14:36
* @Version 1.0
*/
public interface RedisService {

    /**
     * findById
     * @param key
     * @return
     */
    public Page findByKey(String key, Pageable pageable);

    /**
     * create
     * @param redisVo
     */
    public void save(RedisVo redisVo);

    /**
     * delete
     * @param key
     */
    public void delete(String key);

    /**
     * 清空所有缓存
     */
    public void flushdb();
}
