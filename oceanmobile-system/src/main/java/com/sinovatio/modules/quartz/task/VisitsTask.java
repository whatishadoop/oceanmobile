package com.sinovatio.modules.quartz.task;

import com.sinovatio.modules.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @ClassName: VisitsTask
* @Description: 用户访问任务统计
* @Author JinLu
* @Date 2019/4/19 14:44
* @Version 1.0
*/
@Component
public class VisitsTask {

    @Autowired
    private VisitsService visitsService;

    public void run(){
        visitsService.save();
    }
}
