package com.sinovatio.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
* @ClassName: ThreadPoolUtil
* @Description: 可以考虑使用 spring-boot 自带的线程池 ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();进行任务调度
* @Author JinLu
* @Date 2019/4/3 11:57
* @Version 1.0
*/
@Configuration
public class ThreadPoolUtil {

    @Bean
    public ExecutorService getThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        int size = 2;
        ExecutorService executorService = new ThreadPoolExecutor(size,size,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
        return executorService;
    }
}
