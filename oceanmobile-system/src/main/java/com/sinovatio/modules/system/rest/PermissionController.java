package com.sinovatio.modules.system.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.modules.system.domain.Permission;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.modules.system.service.PermissionService;
import com.sinovatio.modules.system.service.dto.PermissionDTO;
import com.sinovatio.modules.system.service.query.PermissionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: MenuController
 * @Description: 权限服务接口
 * @Author JinLu
 * @Date 2019/4/3 17:06
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionQueryService permissionQueryService;

    private static final String ENTITY_NAME = "permission";

    @GetMapping(value = "/permissions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResponseEntity getPermissions(@PathVariable Long id){
        return new ResponseEntity(permissionService.findById(id), HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 返回全部的权限，新增角色时下拉选择
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:11
    */
    @GetMapping(value = "/permissions/tree")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT','ROLES_SELECT','ROLES_ALL')")
    public ResponseEntity getRoleTree(){
        return new ResponseEntity(permissionService.getPermissionTree(permissionService.findByPid(0L)),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 查询权限
     * @param name
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:11
    */
    @Log("查询权限")
    @GetMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResponseEntity getPermissions(@RequestParam(required = false) String name){
        List<PermissionDTO> permissionDTOS = permissionQueryService.queryAll(name);
        return new ResponseEntity(permissionService.buildTree(permissionDTOS),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 新增权限
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:12
    */
    @Log("新增权限")
    @PostMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Permission resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(permissionService.create(resources),HttpStatus.CREATED);
    }

    /**
     * @Author JinLu
     * @Description: 修改权限
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:12
    */
    @Log("修改权限")
    @PutMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Permission resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        permissionService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * @Author JinLu
     * @Description: 修改权限
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:12
    */
    @Log("删除权限")
    @DeleteMapping(value = "/permissions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        permissionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
