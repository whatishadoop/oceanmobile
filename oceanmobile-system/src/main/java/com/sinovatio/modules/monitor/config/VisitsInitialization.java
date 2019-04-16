package com.sinovatio.modules.monitor.config;

import com.sinovatio.modules.monitor.service.VisitsService;
import org.springframework.context.annotation.Configuration;

/**
* @ClassName: VisitsInitialization
* @Description: 初始化站点统计
* @Author JinLu
* @Date 2019/4/3 16:08
* @Version 1.0
*/
@Configuration
public class VisitsInitialization {

    public VisitsInitialization(VisitsService visitsService){
        System.out.println("--------------- 初始化站点统计，如果存在今日统计则跳过 ---------------");
        visitsService.save();
        System.out.println("--------------- 初始化站点统计完成 ---------------");
    }
}
