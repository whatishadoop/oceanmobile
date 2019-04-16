package com.sinovatio.modules.quartz.utils;

import lombok.extern.slf4j.Slf4j;
import com.sinovatio.utils.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @ClassName: QuartzRunnable
 * @Description: 执行定时任务
 * @Author JinLu
 * @Date 2019/4/3 16:47
 * @Version 1.0
 */
@Slf4j
public class QuartzRunnable implements Runnable {

    private Object target;
    private Method method;
    private String params;

    QuartzRunnable(String beanName, String methodName, String params)
            throws NoSuchMethodException, SecurityException {
        this.target = SpringContextHolder.getBean(beanName);
        this.params = params;

        if (StringUtils.isNotBlank(params)) {
            this.method = target.getClass().getDeclaredMethod(methodName, String.class);
        } else {
            this.method = target.getClass().getDeclaredMethod(methodName);
        }
    }

    @Override
    public void run() {
        try {
            // 使 filed 变为可访问
            ReflectionUtils.makeAccessible(method);
            if (StringUtils.isNotBlank(params)) {
                method.invoke(target, params);
            } else {
                method.invoke(target);
            }
        } catch (Exception e) {
            log.error("定时任务执行失败", e);
        }
    }

}
