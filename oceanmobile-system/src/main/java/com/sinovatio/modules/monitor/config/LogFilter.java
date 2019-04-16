package com.sinovatio.modules.monitor.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.sinovatio.modules.monitor.domain.LogMessage;
import java.text.DateFormat;
import java.util.Date;

/**
* @ClassName: LogFilter
* @Description: 定义Logfilter拦截输出日志
* @Author JinLu
* @Date 2019/4/3 16:08
* @Version 1.0
*/
public class LogFilter extends Filter<ILoggingEvent>{

    @Override
    public FilterReply decide(ILoggingEvent event) {
        String exception = "";
        IThrowableProxy iThrowableProxy1 = event.getThrowableProxy();
        LogMessage loggerMessage = new LogMessage(
                event.getFormattedMessage(),
                DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())),
                event.getThreadName(),
                event.getLoggerName(),
                event.getLevel().levelStr
        );
        LoggerQueue.getInstance().push(loggerMessage);
        return FilterReply.ACCEPT;
    }
}