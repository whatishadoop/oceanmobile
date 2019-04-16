package com.sinovatio.modules.system.service;

import com.sinovatio.modules.system.domain.Menu;
import com.sinovatio.modules.system.domain.Role;
import com.sinovatio.modules.system.service.dto.MenuDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @ClassName: MenuService
* @Description: 菜单业务服务
* @Author JinLu
* @Date 2019/4/3 17:26
* @Version 1.0
*/
@CacheConfig(cacheNames = "menu")
public interface MenuService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    MenuDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    MenuDTO create(Menu resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Menu resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    Object getMenuTree(List<Menu> menus);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<Menu> findByPid(long pid);

    /**
     * build Tree
     * @param menuDTOS
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Map buildTree(List<MenuDTO> menuDTOS);

    /**
     * findByRoles
     * @param roles
     * @return
     */
    List<MenuDTO> findByRoles(Set<Role> roles);

    /**
     * buildMenus
     * @param byRoles
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Object buildMenus(List<MenuDTO> byRoles);
}
