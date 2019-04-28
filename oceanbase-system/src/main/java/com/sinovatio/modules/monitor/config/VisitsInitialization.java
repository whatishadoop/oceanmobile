package com.sinovatio.modules.monitor.config;

import com.sinovatio.modules.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
* @ClassName: VisitsInitialization
* @Description: 初始化站点统计
* @Author JinLu
* @Date 2019/4/19 14:33
* @Version 1.0
*/
@Component
public class VisitsInitialization implements ApplicationRunner {

    @Autowired
    private VisitsService visitsService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--------------- 初始化站点统计，如果存在今日统计则跳过 ---------------");
        visitsService.save();
        System.out.println("--------------- 初始化站点统计完成 ---------------");
    }
}
