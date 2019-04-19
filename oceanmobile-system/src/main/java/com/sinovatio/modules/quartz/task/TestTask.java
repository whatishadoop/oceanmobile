package com.sinovatio.modules.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
* @ClassName: TestTask
* @Description: 测试任务
* @Author JinLu
* @Date 2019/4/19 14:43
* @Version 1.0
*/
@Slf4j
@Component
public class TestTask {

    public void run(){
        log.info("执行成功");
    }

    public void run1(String str){
        log.info("执行成功，参数为： {}" + str);
    }
}
