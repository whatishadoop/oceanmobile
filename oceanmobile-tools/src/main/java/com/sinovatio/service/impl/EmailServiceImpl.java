package com.sinovatio.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.sinovatio.domain.EmailConfig;
import com.sinovatio.domain.vo.EmailVo;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.repository.EmailRepository;
import com.sinovatio.service.EmailService;
import com.sinovatio.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @ClassName: EmailServiceImpl
* @Description: 邮件支付服务
* @Author JinLu
* @Date 2019/4/19 16:15
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailConfig update(EmailConfig emailConfig, EmailConfig old) {
        try {
            if(!emailConfig.getPass().equals(old.getPass())){
                // 对称加密
                emailConfig.setPass(EncryptUtils.desEncrypt(emailConfig.getPass()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailRepository.save(emailConfig);
    }

    @Override
    public EmailConfig find() {
        Optional<EmailConfig> emailConfig = emailRepository.findById(1L);
        if(emailConfig.isPresent()){
            return emailConfig.get();
        } else {
            return new EmailConfig();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void send(EmailVo emailVo, EmailConfig emailConfig){
        if(emailConfig == null){
            throw new BadRequestException("请先配置，再操作");
        }
        /**
         * 封装
         */
        MailAccount account = new MailAccount();
        account.setHost(emailConfig.getHost());
        account.setPort(Integer.parseInt(emailConfig.getPort()));
        account.setAuth(true);
        try {
            // 对称解密
            account.setPass(EncryptUtils.desDecrypt(emailConfig.getPass()));
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
        account.setFrom(emailConfig.getUser()+"<"+emailConfig.getFromUser()+">");
        //ssl方式发送
        account.setStartttlsEnable(true);
        String content = emailVo.getContent();
        /**
         * 发送
         */
        try {
            MailUtil.send(account,
                          emailVo.getTos(),
                          emailVo.getSubject(),
                          content,
                          true);
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }
}
