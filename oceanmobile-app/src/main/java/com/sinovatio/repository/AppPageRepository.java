package com.sinovatio.repository;

import com.sinovatio.domain.AppPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: AppPageRepository
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/6 16:13
 * @Version 1.0
 */
public interface AppPageRepository extends JpaRepository<AppPage, Long>, JpaSpecificationExecutor {

}
