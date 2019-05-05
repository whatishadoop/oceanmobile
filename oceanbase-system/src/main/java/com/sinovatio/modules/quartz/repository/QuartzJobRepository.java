package com.sinovatio.modules.quartz.repository;

import com.sinovatio.modules.quartz.domain.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* @ClassName: QuartzJobRepository
* @Description: 定时任务jpa操作
* @Author JinLu
* @Date 2019/4/19 14:40
* @Version 1.0
*/
public interface QuartzJobRepository extends JpaRepository<QuartzJob,Long>, JpaSpecificationExecutor {

    /**
     * 更新状态
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying  //  @Query 使用update更新或删除执行dml操作时,需要设置@Modifying 以及@Transactional事物，否则执行报错
    @Query(value = "update quartz_job set is_pause = 1 where id = ?1",nativeQuery = true)
    void updateIsPause(Long id);

    /**
     * 查询不是启用的任务
     * @return
     */
    List<QuartzJob> findByIsPauseIsFalse();
}
