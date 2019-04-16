package com.sinovatio.aspect;

import com.google.common.collect.ImmutableList;
import com.sinovatio.aop.limit.Limit;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.utils.RequestHolder;
import com.sinovatio.utils.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
* @ClassName: LimitAspect
* @Description: 配置切面
* @Author JinLu
* @Date 2019/4/3 11:37
* @Version 1.0
*/
@Aspect
@Component
public class LimitAspect {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    // 方法一: "execution(public * com.example.demo.controller.*.*(..)) && @annotation(com.example.demo.controller.MyAnnotation)"，这样在controller包下，只有我们加上@MyAnnotation注解的方法切面方法才会起作用。
    // 方法二: 加载切点注解类定义上，从而实现注解切面 ,此时只要加注解就实现切面功能
    @Pointcut("@annotation(com.sinovatio.aop.limit.Limit)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method signatureMethod = signature.getMethod();
        Limit limit = signatureMethod.getAnnotation(Limit.class);
        LimitType limitType = limit.limitType();
        String name = limit.name();
        String key = limit.key();
        if (StringUtils.isEmpty(key)) {
            switch (limitType) {
                case IP:
                    key = StringUtils.getIP(request);
                    break;
                default:
                    key = signatureMethod.getName();
            }
        }

        ImmutableList keys = ImmutableList.of(StringUtils.join(limit.prefix(), "_", key, "_", request.getRequestURI().replaceAll("/","_")));

        String luaScript = buildLuaScript();
        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
        Number count = (Number) redisTemplate.execute(redisScript, keys, limit.count(), limit.period());
        if (null != count && count.intValue() <= limit.count()) {
            logger.info("第{}次访问key为 {}，描述为 [{}] 的接口", count, keys, limit.name());
            return joinPoint.proceed();
        } else {
            throw new BadRequestException("访问次数受限制");
        }
    }

    /**
     * lua限流脚本
     */
    private String buildLuaScript() {
        return "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
    }
}
