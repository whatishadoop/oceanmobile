package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

/**
* @ClassName: RoleRepository
* @Description: 角色jpa
* @Author JinLu
* @Date 2019/4/19 15:48
* @Version 1.0
*/
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Role findByName(String name);

    Set<Role> findByUsers_Id(Long id);

    Set<Role> findByMenus_Id(Long id);
}
