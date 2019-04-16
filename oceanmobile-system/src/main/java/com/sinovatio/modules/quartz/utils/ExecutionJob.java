package com.sinovatio.modules.quartz.utils;

import com.sinovatio.modules.quartz.domain.QuartzJob;
import com.sinovatio.modules.quartz.domain.QuartzLog;
import com.sinovatio.modules.quartz.repository.QuartzLogRepository;
import com.sinovatio.modules.quartz.service.QuartzJobService;
import com.sinovatio.utils.SpringContextHolder;
import com.sinovatio.utils.ThrowableUtil;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @ClassName: ExecutionJob
 * @Description: 执行任务
 * @Author JinLu
 * @Date 2019/4/3 16:44
 * @Version 1.0
 */
@Async
// @DisallowConcurrentExecution // 设置异步执行
public class ExecutionJob extends QuartzJobBean {

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExecutorService executorService;

    // 下面定义定时操作的代码
    @Override
    protected void executeInternal(JobExecutionContext context) {
        QuartzJob quartzJob = (QuartzJob) context.getMergedJobDataMap().get(QuartzJob.JOB_KEY);
        // 获取spring bean
        QuartzLogRepository quartzLogRepository = SpringContextHolder.getBean("quartzLogRepository");
        QuartzJobService quartzJobService = SpringContextHolder.getBean("quartzJobService");
        QuartzManage quartzManage = SpringContextHolder.getBean("quartzManage");

        QuartzLog log = new QuartzLog();
        log.setJobName(quartzJob.getJobName());
        log.setBeanName(quartzJob.getBeanName());
        log.setMethodName(quartzJob.getMethodName());
        log.setParams(quartzJob.getParams());
        long startTime = System.currentTimeMillis();
        log.setCronExpression(quartzJob.getCronExpression());
        try {
            // 执行任务
            logger.info("任务准备执行，任务名称：{}", quartzJob.getJobName());
            QuartzRunnable task = new QuartzRunnable(quartzJob.getBeanName(), quartzJob.getMethodName(),
                    quartzJob.getParams());
            // 在使用线程池调度任务
            Future<?> future = executorService.submit(task);
            future.get();
            long times = System.currentTimeMillis() - startTime;
            log.setTime(times);  // 设置日志执行耗时间
            // 任务状态
            log.setIsSuccess(true);
            logger.info("任务执行完毕，任务名称：{} 总共耗时：{} 毫秒", quartzJob.getJobName(), times);
        } catch (Exception e) {
            logger.error("任务执行失败，任务名称：{}" + quartzJob.getJobName(), e);
            long times = System.currentTimeMillis() - startTime;
            log.setTime(times);
            // 任务状态 0：成功 1：失败
            log.setIsSuccess(false);
            log.setExceptionDetail(ThrowableUtil.getStackTrace(e));
            //出错就暂停任务
            quartzManage.pauseJob(quartzJob);
            //更新状态
            quartzJobService.updateIsPause(quartzJob);
        } finally {
            quartzLogRepository.save(log);
        }
    }
}
