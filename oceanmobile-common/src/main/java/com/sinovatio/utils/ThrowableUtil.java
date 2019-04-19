package com.sinovatio.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
* @ClassName: ThrowableUtil
* @Description: 异常工具
* @Author JinLu
* @Date 2019/4/19 14:23
* @Version 1.0
*/
public class ThrowableUtil {

    /**
     * 获取堆栈信息
     * @param throwable
     * @return
     */
    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
