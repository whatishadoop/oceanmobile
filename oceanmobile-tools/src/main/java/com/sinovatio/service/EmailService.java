package com.sinovatio.service;

import com.sinovatio.domain.EmailConfig;
import com.sinovatio.domain.vo.EmailVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;

/**
* @ClassName: EmailService
* @Description: 邮件服务
* @Author JinLu
* @Date 2019/4/4 10:45
* @Version 1.0
*/
@CacheConfig(cacheNames = "email")
public interface EmailService {

    /**
     * 更新邮件配置
     * @param emailConfig
     * @param old
     * @return
     */
    @CachePut(key = "'1'")
    EmailConfig update(EmailConfig emailConfig, EmailConfig old);

    /**
     * 查询配置
     * @return
     */
    @Cacheable(key = "'1'")
    EmailConfig find();

    /**
     * 发送邮件
     * @param emailVo
     * @param emailConfig
     * @throws Exception
     */
    @Async
    void send(EmailVo emailVo, EmailConfig emailConfig) throws Exception;
}
