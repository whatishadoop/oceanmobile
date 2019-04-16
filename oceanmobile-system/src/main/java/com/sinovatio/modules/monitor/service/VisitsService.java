package com.sinovatio.modules.monitor.service;

import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: VisitsService
 * @Description: 用户访问服务
 * @Author JinLu
 * @Date 2019/4/3 16:17
 * @Version 1.0
 */
public interface VisitsService {

    /**
    * @ClassName: VisitsService
    * @Description: 提供给定时任务，每天0点执行
    * @Author JinLu
    * @Date 2019/4/3 16:21
    * @Version 1.0
    */
    void save();

    /**
     * @Author JinLu
     * @Description: 新增记录
     * @Return
     * @Date 2019/4/3 16:21
    */
    @Async
    void count(HttpServletRequest request);

    /**
     * @Author JinLu
     * @Description: 获取数据
     * @Return
     * @Date 2019/4/3 16:21
    */
    Object get();

    /**
     * @Author JinLu
     * @Description: 获取图表统计数据
     * @Return
     * @Date 2019/4/3 16:22
    */
    Object getChartData();
}
