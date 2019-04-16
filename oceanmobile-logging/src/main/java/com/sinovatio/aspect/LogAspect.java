package com.sinovatio.aspect;

import lombok.extern.slf4j.Slf4j;
import com.sinovatio.domain.Log;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.service.LogService;
import com.sinovatio.utils.ThrowableUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author JinLu
 * @Description:  日志采集切面，切点定义
 * @param null
 * @Return 
 * @Date 2019/4/3 14:46
*/
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private LogService logService;

    private long currentTime = 0L;

    /**
     * @Author JinLu
     * @Description: 配置切入点
     * @Return void
     * @Date 2019/4/3 14:56
    */
    @Pointcut("@annotation(com.sinovatio.aop.log.Log)")
    public void logPointcut() {
        // 该方法无方法体,主要为了指定对应的类配置使用此切入点注释
    }

    /**
     * @Author JinLu
     * @Description: 配置环绕通知,使用在方法logPointcut()上注册的切入点
     * @param joinPoint 原始调用对象
     * @Return java.lang.Object
     * @Date 2019/4/3 14:56
    */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint){
        Object result = null;
        currentTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new BadRequestException(e.getMessage());
        }
        Log log = new Log("INFO",System.currentTimeMillis() - currentTime);
        logService.save(joinPoint, log);
        return result;
    }

    /**
     * @Author JinLu
     * @Description: 配置异常通知
     * @param joinPoint 原始调用对象
     * @param e 异常对象
     * @Return void
     * @Date 2019/4/3 14:56
    */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Log log = new Log("ERROR",System.currentTimeMillis() - currentTime);
        // 记录异常信息
        log.setExceptionDetail(ThrowableUtil.getStackTrace(e));
        logService.save((ProceedingJoinPoint)joinPoint, log);
    }
}
