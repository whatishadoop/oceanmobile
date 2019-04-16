package com.sinovatio.modules.system.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.modules.system.domain.Role;
import com.sinovatio.modules.system.service.RoleService;
import com.sinovatio.modules.system.service.query.RoleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MenuController
 * @Description: 角色服务接口
 * @Author JinLu
 * @Date 2019/4/3 17:06
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleQueryService roleQueryService;

    private static final String ENTITY_NAME = "role";

    /**
     * @Author JinLu
     * @Description: 根据id查找对应角色
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:11
    */
    @GetMapping(value = "/roles/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_SELECT')")
    public ResponseEntity getRoles(@PathVariable Long id){
        return new ResponseEntity(roleService.findById(id), HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 返回全部的角色，新增用户时下拉选择
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:10
    */
    @GetMapping(value = "/roles/tree")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT','ROLES_ALL','USER_ALL','USER_SELECT')")
    public ResponseEntity getRoleTree(){
        return new ResponseEntity(roleService.getRoleTree(),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 查询角色
     * @param name
     * @param pageable
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:10
    */
    @Log("查询角色")
    @GetMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_SELECT')")
    public ResponseEntity getRoles(@RequestParam(required = false) String name,  Pageable pageable){
        return new ResponseEntity(roleQueryService.queryAll(name,pageable),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 新增角色
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:10
    */
    @Log("新增角色")
    @PostMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Role resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(roleService.create(resources),HttpStatus.CREATED);
    }

    /**
     * @Author JinLu
     * @Description: 修改角色
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:10
    */
    @Log("修改角色")
    @PutMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Role resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        roleService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * @Author JinLu
     * @Description: 根据id删除角色
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:10
    */
    @Log("删除角色")
    @DeleteMapping(value = "/roles/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        roleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
