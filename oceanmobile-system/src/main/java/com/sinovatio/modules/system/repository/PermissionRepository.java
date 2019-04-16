package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Permission;
import com.sinovatio.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: MenuRepository
 * @Description: 权限持久化操作
 * @Author JinLu
 * @Date 2019/4/3 17:04
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
     * findByRoles
     * @param roleSet
     * @return
     */
    Set<Permission> findByRoles(Set<Role> roleSet);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<Permission> findByPid(long pid);
}
