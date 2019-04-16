package com.sinovatio.modules.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
* @ClassName: TestTask
* @Description: 测试使用
* @Author JinLu
* @Date 2019/4/3 16:36
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
