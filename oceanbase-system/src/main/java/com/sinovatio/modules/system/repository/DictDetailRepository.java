package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.DictDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @ClassName: DictDetailRepository
* @Description: 字典详情jpa
* @Author JinLu
* @Date 2019/4/19 15:46
* @Version 1.0
*/
public interface DictDetailRepository extends JpaRepository<DictDetail, Long>, JpaSpecificationExecutor {
}