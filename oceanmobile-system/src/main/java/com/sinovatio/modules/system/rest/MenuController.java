package com.sinovatio.modules.system.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.modules.security.utils.JwtTokenUtil;
import com.sinovatio.modules.system.domain.Menu;
import com.sinovatio.modules.system.domain.User;
import com.sinovatio.modules.system.service.MenuService;
import com.sinovatio.modules.system.service.UserService;
import com.sinovatio.modules.system.service.dto.MenuDTO;
import com.sinovatio.modules.system.service.query.MenuQueryService;
import com.sinovatio.utils.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @ClassName: MenuController
* @Description: 菜单服务接口
* @Author JinLu
* @Date 2019/4/3 17:06
* @Version 1.0
*/
@RestController
@RequestMapping("api")
public class MenuController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuQueryService menuQueryService;

    @Autowired
    private UserService userService;

    private static final String ENTITY_NAME = "menu";

    /**
     * @Author JinLu
     * @Description: 根据id查找对应的菜单
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:14
    */
    @GetMapping(value = "/menus/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT')")
    public ResponseEntity getMenus(@PathVariable Long id){
        return new ResponseEntity(menuService.findById(id), HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 构建前端路由所需要的菜单
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:12
    */
    @GetMapping(value = "/menus/build")
    public ResponseEntity buildMenus(){
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        User user = userService.findByName(userDetails.getUsername());
        List<MenuDTO> menuDTOList = menuService.findByRoles(user.getRoles());
        List<MenuDTO> menuDTOTree = (List<MenuDTO>)menuService.buildTree(menuDTOList).get("content");
        return new ResponseEntity(menuService.buildMenus(menuDTOTree),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 返回全部的菜单
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:13
    */
    @GetMapping(value = "/menus/tree")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT')")
    public ResponseEntity getMenuTree(){
        return new ResponseEntity(menuService.getMenuTree(menuService.findByPid(0L)),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 查询菜单
     * @param name
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:13
    */
    @Log("查询菜单")
    @GetMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT')")
    public ResponseEntity getMenus(@RequestParam(required = false) String name){
        List<MenuDTO> menuDTOList = menuQueryService.queryAll(name);
        return new ResponseEntity(menuService.buildTree(menuDTOList),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 新增菜单
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:13
    */
    @Log("新增菜单")
    @PostMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Menu resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(menuService.create(resources),HttpStatus.CREATED);
    }

    /**
     * @Author JinLu
     * @Description: 修改菜单
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:13
    */
    @Log("修改菜单")
    @PutMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Menu resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        menuService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * @Author JinLu
     * @Description: 根据id删除对应的菜单
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:13
    */
    @Log("删除菜单")
    @DeleteMapping(value = "/menus/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        menuService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
