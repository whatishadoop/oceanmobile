package com.sinovatio.modules.system.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.config.DataScope;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.modules.system.domain.Dept;
import com.sinovatio.modules.system.service.DeptService;
import com.sinovatio.modules.system.service.dto.DeptDTO;
import com.sinovatio.modules.system.service.query.DeptQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
* @ClassName: DeptController
* @Description: 部门服务接口
* @Author JinLu
* @Date 2019/4/19 15:49
* @Version 1.0
*/
@RestController
@RequestMapping("api")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DeptQueryService deptQueryService;

    @Autowired
    private DataScope dataScope;

    private static final String ENTITY_NAME = "dept";

    @Log("查询部门")
    @GetMapping(value = "/dept")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT','DEPT_ALL','DEPT_SELECT')")
    public ResponseEntity getDepts(DeptDTO resources){
        // 数据权限
        Set<Long> deptIds = dataScope.getDeptIds();
        List<DeptDTO> deptDTOS = deptQueryService.queryAll(resources, deptIds);
        return new ResponseEntity(deptService.buildTree(deptDTOS),HttpStatus.OK);
    }

    @Log("新增部门")
    @PostMapping(value = "/dept")
    @PreAuthorize("hasAnyRole('ADMIN','DEPT_ALL','DEPT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Dept resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(deptService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改部门")
    @PutMapping(value = "/dept")
    @PreAuthorize("hasAnyRole('ADMIN','DEPT_ALL','DEPT_EDIT')")
    public ResponseEntity update(@Validated(Dept.Update.class) @RequestBody Dept resources){
        deptService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除部门")
    @DeleteMapping(value = "/dept/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DEPT_ALL','DEPT_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        deptService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}