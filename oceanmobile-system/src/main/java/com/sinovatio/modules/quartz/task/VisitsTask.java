package com.sinovatio.modules.quartz.task;

import com.sinovatio.modules.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @ClassName: VisitsTask
* @Description: 用户访问任务
* @Author JinLu
* @Date 2019/4/3 16:36
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
