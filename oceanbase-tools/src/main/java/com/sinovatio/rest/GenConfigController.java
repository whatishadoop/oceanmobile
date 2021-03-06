package com.sinovatio.rest;

import com.sinovatio.domain.GenConfig;
import com.sinovatio.service.GenConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @ClassName: GenConfigController
* @Description: 代码生成配置服务接口
* @Author JinLu
* @Date 2019/4/19 14:25
* @Version 1.0
*/
@RestController
@RequestMapping("api")
public class GenConfigController {

    @Autowired
    private GenConfigService genConfigService;

    /**
     * 查询生成器配置
     * @return
     */
    @GetMapping(value = "/genConfig")
    public ResponseEntity get(){
        return new ResponseEntity(genConfigService.find(), HttpStatus.OK);
    }

    @PutMapping(value = "/genConfig")
    public ResponseEntity emailConfig(@Validated @RequestBody GenConfig genConfig){
        return new ResponseEntity(genConfigService.update(genConfig),HttpStatus.OK);
    }
}
