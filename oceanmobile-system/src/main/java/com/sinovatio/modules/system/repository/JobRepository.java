package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @ClassName: JobRepository
* @Description: 岗位jpa
* @Author JinLu
* @Date 2019/4/19 15:47
* @Version 1.0
*/
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor {
}