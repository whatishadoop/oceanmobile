package com.sinovatio.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.domain.Application;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.service.ApplicationService;
import com.sinovatio.service.dto.ApplicationDTO;
import com.sinovatio.service.query.ApplicationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ApplicationController
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 14:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    private ApplicationQueryService applicationQueryService;

    private static final String ENTITY_NAME = "app_application";

    @Log("查询应用")
    @GetMapping(value = "/application")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getApplications(ApplicationDTO application, Pageable pageable){
        return new ResponseEntity(applicationQueryService.queryAll(application,pageable), HttpStatus.OK);
    }

    @Log("新增应用")
    @PostMapping(value="/application")
    //@PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create( @Validated @RequestBody Application applicaion){
        System.out.println("-=======================");
        if (applicaion.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(applicationService.create(applicaion), HttpStatus.OK);
    }

    @Log("修改应用")
    @PutMapping(value="/application")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody Application application){
        applicationService.update(application);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("删除应用")
    @DeleteMapping(value="/application/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        applicationService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
