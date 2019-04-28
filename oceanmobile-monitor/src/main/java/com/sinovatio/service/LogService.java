package com.sinovatio.service;

import com.sinovatio.domain.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
* @ClassName: LogService
* @Description: 日志查询服务
* @Author JinLu
* @Date 2019/4/19 14:30
* @Version 1.0
*/
public interface LogService {

    /**
     * 新增日志
     * @param joinPoint
     * @param log
     */
    @Async
    void save(ProceedingJoinPoint joinPoint, Log log);
}
