package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.DictDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-04-10
*/
public interface DictDetailRepository extends JpaRepository<DictDetail, Long>, JpaSpecificationExecutor {
}