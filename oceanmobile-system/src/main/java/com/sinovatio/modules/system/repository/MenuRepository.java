package com.sinovatio.modules.system.repository;

import com.sinovatio.modules.system.domain.Menu;
import com.sinovatio.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Set;

/**
* @ClassName: MenuRepository
* @Description: 菜单持久化操作
* @Author JinLu
* @Date 2019/4/3 17:04
* @Version 1.0
*/
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Menu findByName(String name);

    /**
     * findByRoles
     * @param roleSet
     * @return
     */
    Set<Menu> findByRolesOrderBySort(Set<Role> roleSet);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<Menu> findByPid(long pid);
}
