package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @ClassName: DictRepository
* @Description: 字典jpa
* @Author JinLu
* @Date 2019/4/19 15:46
* @Version 1.0
*/
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor {
}