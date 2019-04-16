package com.sinovatio.modules.monitor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* @ClassName: LogMessage
* @Description: 日志对象
* @Author JinLu
* @Date 2019/4/3 16:10
* @Version 1.0
*/
@Data
@AllArgsConstructor
public class LogMessage {

    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
}
