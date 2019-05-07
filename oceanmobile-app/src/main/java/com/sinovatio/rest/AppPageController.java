package com.sinovatio.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.domain.AppPage;
import com.sinovatio.service.AppPageService;
import com.sinovatio.service.dto.AppPageDTO;
import com.sinovatio.service.query.AppPageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: AppPageController
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 14:46
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class AppPageController {
    // 默认注入该接口实现类实例，若多个实现则要使用@Qualifier注解指定对应实现类，在@service("xxx")中定义
    @Autowired
    private AppPageService appPageService;
    @Autowired
    private AppPageQueryService appPageQueryService;

    private static final String ENTITY_NAME = "app_page";

    @Log("查询应用页面")
    @GetMapping(value="/apppage")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getAppPages(AppPageDTO appPageDTO, Pageable pageable){
        return new ResponseEntity(appPageQueryService.queryAll(appPageDTO,pageable), HttpStatus.OK);
    }

    @Log("新增应用页面")
    @PostMapping(value = "/apppage")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody AppPage appPage){
       return new ResponseEntity(appPageService.create(appPage),HttpStatus.CREATED);
    }

    @Log("修改应用页面")
    @PutMapping(value="/apppage")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity update(@Validated @RequestBody AppPage appPage){
        appPageService.update(appPage);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("删除应用页面")
    @DeleteMapping(value = "/apppage")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        appPageService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
