package com.sinovatio.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.domain.AppBusiSolution;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.service.AppBusiSolutionService;
import com.sinovatio.service.dto.AppBusiSolutionDTO;
import com.sinovatio.service.query.AppBusiSolutionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @author admin
* @date 2019-05-21
*/
@RestController
@RequestMapping("api")
public class AppBusiSolutionController {

    @Autowired
    private AppBusiSolutionService appBusiSolutionService;

    @Autowired
    private AppBusiSolutionQueryService appBusiSolutionQueryService;

    private static final String ENTITY_NAME = "appBusiSolution";

    @Log("查询AppBusiSolution")
    @GetMapping(value = "/appBusiSolution")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getAppBusiSolutions(AppBusiSolutionDTO resources, Pageable pageable){
        return new ResponseEntity(appBusiSolutionQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("查询AppBusiSolutionTree")
    @GetMapping(value = "/appBusiSolutionTree")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getAppBusiSolutionsTree(AppBusiSolutionDTO resources, Pageable pageable){
        List<AppBusiSolutionDTO> appBusiSolutionDTOs =  appBusiSolutionQueryService.queryAll(resources);
        return new ResponseEntity(appBusiSolutionService.buildTree(appBusiSolutionDTOs),HttpStatus.OK);
    }

    @Log("新增AppBusiSolution")
    @PostMapping(value = "/appBusiSolution")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody AppBusiSolution resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(appBusiSolutionService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AppBusiSolution")
    @PutMapping(value = "/appBusiSolution")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody AppBusiSolution resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        appBusiSolutionService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AppBusiSolution")
    @DeleteMapping(value = "/appBusiSolution/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        appBusiSolutionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}