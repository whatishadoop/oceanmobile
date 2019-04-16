package com.sinovatio.modules.monitor.service;

import com.sinovatio.modules.monitor.domain.vo.RedisVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName: RedisServiceImpl
 * @Description: redis缓存服务
 * @Author JinLu
 * @Date 2019/4/3 16:16
 * @Version 1.0
 */
public interface RedisService {

    /**
     * @Author JinLu
     * @Description: 根据键名查找对应缓存数据页
     * @Return
     * @Date 2019/4/3 16:19
    */
    public Page findByKey(String key, Pageable pageable);

    /**
     * @Author JinLu
     * @Description: 保存缓存对象
     * @Return
     * @Date 2019/4/3 16:20
    */
    public void save(RedisVo redisVo);

    /**
     * @Author JinLu
     * @Description: 根据键名删除缓存
     * @Return
     * @Date 2019/4/3 16:18
    */
    public void delete(String key);

    /**
     * @Author JinLu
     * @Description: 清空所有缓存
     * @Return
     * @Date 2019/4/3 16:18
    */
    public void flushdb();
}
