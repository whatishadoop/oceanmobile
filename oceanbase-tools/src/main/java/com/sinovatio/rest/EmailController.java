package com.sinovatio.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.domain.EmailConfig;
import com.sinovatio.domain.vo.EmailVo;
import com.sinovatio.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @ClassName: EmailController
* @Description: 发送邮件服务接口
* @Author JinLu
* @Date 2019/4/19 16:12
* @Version 1.0
*/
@Slf4j
@RestController
@RequestMapping("api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/email")
    public ResponseEntity get(){
        return new ResponseEntity(emailService.find(),HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping(value = "/email")
    public ResponseEntity emailConfig(@Validated @RequestBody EmailConfig emailConfig){
        emailService.update(emailConfig,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping(value = "/email")
    public ResponseEntity send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        log.warn("REST request to send Email : {}" +emailVo);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }
}
