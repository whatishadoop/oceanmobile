package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
* @ClassName: DeptRepository
* @Description: 部门jpa操作
* @Author JinLu
* @Date 2019/4/19 15:46
* @Version 1.0
*/
public interface DeptRepository extends JpaRepository<Dept, Long>, JpaSpecificationExecutor {

    /**
     * findByPid
     * @param id
     * @return
     */
    List<Dept> findByPid(Long id);

    Set<Dept> findByRoles_Id(Long id);
}