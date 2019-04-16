package com.sinovatio.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
* @ClassName: RequestHolder
* @Description: 获取 HttpServletRequest
* @Author JinLu
* @Date 2019/4/3 11:53
* @Version 1.0
*/
public class RequestHolder {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
