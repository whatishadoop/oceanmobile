package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: MenuRepository
 * @Description: 角色持久化操作
 * @Author JinLu
 * @Date 2019/4/3 17:04
 * @Version 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Role findByName(String name);
}
