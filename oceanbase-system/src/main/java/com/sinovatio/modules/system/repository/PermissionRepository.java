package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
* @ClassName: PermissionRepository
* @Description: 权限jpa
* @Author JinLu
* @Date 2019/4/19 15:48
* @Version 1.0
*/
public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Permission findByName(String name);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<Permission> findByPid(long pid);
}
