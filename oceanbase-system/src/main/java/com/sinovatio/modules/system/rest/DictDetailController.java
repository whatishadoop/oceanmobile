package com.sinovatio.modules.system.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.modules.system.domain.DictDetail;
import com.sinovatio.modules.system.service.DictDetailService;
import com.sinovatio.modules.system.service.dto.DictDetailDTO;
import com.sinovatio.modules.system.service.query.DictDetailQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @ClassName: DictDetailController
* @Description: 字典详情服务接口
* @Author JinLu
* @Date 2019/4/19 15:49
* @Version 1.0
*/
@RestController
@RequestMapping("api")
public class DictDetailController {

    @Autowired
    private DictDetailService dictDetailService;

    @Autowired
    private DictDetailQueryService dictDetailQueryService;

    private static final String ENTITY_NAME = "dictDetail";

    @Log("查询字典详情")
    @GetMapping(value = "/dictDetail")
    public ResponseEntity getDictDetails(DictDetailDTO resources,
                                         // 设置排序字段sort, 升序排列，每一页的大小为10，默认从0页开始(第一页)，默认只能每页显示2000条数据
                                         // 通过PageableHandlerMethodArgumentResolver进行配置
                                         @PageableDefault(value = 10, sort = {"sort"}, direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity(dictDetailQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增字典详情")
    @PostMapping(value = "/dictDetail")
    @PreAuthorize("hasAnyRole('ADMIN','DICT_ALL','DICT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody DictDetail resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(dictDetailService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改字典详情")
    @PutMapping(value = "/dictDetail")
    @PreAuthorize("hasAnyRole('ADMIN','DICT_ALL','DICT_EDIT')")
    public ResponseEntity update(@Validated(DictDetail.Update.class) @RequestBody DictDetail resources){
        dictDetailService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除字典详情")
    @DeleteMapping(value = "/dictDetail/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DICT_ALL','DICT_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        dictDetailService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}