package com.sinovatio.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
* @ClassName: SpringContextHolder
* @Description: 解决utils包下的文件中写一个方法的时候想去使用@autowired注入一些对象
* @Author JinLu
* @Date 2019/4/3 11:53
* @Version 1.0
*/
@Slf4j
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    /**
     * @Author JinLu
     * @Description: 取得存储在静态变量中的ApplicationContext.
     * @Param []
     * @Return org.springframework.context.ApplicationContext
     * @Date 2019/4/3 11:54
    */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    /**
     * @Author JinLu
     * @Description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @Param [name]
     * @Return T
     * @Date 2019/4/3 11:54
    */
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     * @Author JinLu
     * @Description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @Param [requiredType]
     * @Return T
     * @Date 2019/4/3 11:54
    */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * @Author JinLu
     * @Description: 检查ApplicationContext不为空.
     * @Param []
     * @Return void
     * @Date 2019/4/3 11:54
    */
    private static void assertContextInjected() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext属性未注入, 请在applicationContext" +
                    ".xml中定义SpringContextHolder或在SpringBoot启动类中注册SpringContextHolder.");
        }
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        log.debug("清除SpringContextHolder中的ApplicationContext:"
                + applicationContext);
        applicationContext = null;
    }

    // 通过bean实现InitializingBean和 DisposableBean接口，用于实例销毁前执行，清空applicationContext,等同于通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
    @Override
    public void destroy() throws Exception {
        SpringContextHolder.clearHolder();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextHolder.applicationContext != null) {
            log.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + SpringContextHolder.applicationContext);
        }
        SpringContextHolder.applicationContext = applicationContext;
    }
}
