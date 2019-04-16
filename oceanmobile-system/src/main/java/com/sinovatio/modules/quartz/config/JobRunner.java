package com.sinovatio.modules.quartz.config;

import com.sinovatio.modules.quartz.domain.QuartzJob;
import com.sinovatio.modules.quartz.repository.QuartzJobRepository;
import com.sinovatio.modules.quartz.utils.QuartzManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.List;

/**
* @ClassName: JobRunner
* @Description: 设置定时器任务
* @Author JinLu
* @Date 2019/4/3 16:23
* @Version 1.0
*/
@Component
public class JobRunner implements ApplicationRunner {

    @Autowired
    private QuartzJobRepository quartzJobRepository;

    @Autowired
    private QuartzManage quartzManage;

    /**
     * @Author JinLu
     * @Description: 项目启动时重新激活启用的定时任务
     * @Return
     * @Date 2019/4/3 16:24
    */
    @Override
    public void run(ApplicationArguments applicationArguments){
        System.out.println("--------------------注入定时任务---------------------");
        List<QuartzJob> quartzJobs = quartzJobRepository.findByIsPauseIsFalse();
        quartzJobs.forEach(quartzJob -> {
            quartzManage.addJob(quartzJob);
        });
        System.out.println("--------------------定时任务注入完成---------------------");
    }
}
