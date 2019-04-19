package com.sinovatio.modules.quartz.repository;

import com.sinovatio.modules.quartz.domain.QuartzLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @ClassName: QuartzLogRepository
* @Description: 定时任务日志jpa操作
* @Author JinLu
* @Date 2019/4/19 14:41
* @Version 1.0
*/
public interface QuartzLogRepository extends JpaRepository<QuartzLog,Long>, JpaSpecificationExecutor {

}
