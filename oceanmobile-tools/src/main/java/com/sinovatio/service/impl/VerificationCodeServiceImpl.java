package com.sinovatio.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.sinovatio.domain.VerificationCode;
import com.sinovatio.domain.vo.EmailVo;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.repository.VerificationCodeRepository;
import com.sinovatio.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.concurrent.*;

/**
* @ClassName: VerificationCodeServiceImpl
* @Author JinLu
* @Date 2019/4/4 10:43
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Value("${code.expiration}")
    private Integer expiration;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailVo sendEmail(VerificationCode code) {
        EmailVo emailVo = null;
        String content = "";
        VerificationCode verificationCode = verificationCodeRepository.findByScenesAndTypeAndValueAndStatusIsTrue(code.getScenes(),code.getType(),code.getValue());
        // 如果不存在有效的验证码，就创建一个新的
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email/email.ftl");
        if(verificationCode == null){
            code.setCode(RandomUtil.randomNumbers (6));
            content = template.render(Dict.create().set("code",code.getCode()));
            emailVo = new EmailVo(Arrays.asList(code.getValue()),"eladmin后台管理系统",content);
            timedDestruction(verificationCodeRepository.save(code));
        // 存在就再次发送原来的验证码
        } else {
            content = template.render(Dict.create().set("code",verificationCode.getCode()));
            emailVo = new EmailVo(Arrays.asList(verificationCode.getValue()),"eladmin后台管理系统",content);
        }
        return emailVo;
    }

    @Override
    public void validated(VerificationCode code) {
        VerificationCode verificationCode = verificationCodeRepository.findByScenesAndTypeAndValueAndStatusIsTrue(code.getScenes(),code.getType(),code.getValue());
        if(verificationCode == null || !verificationCode.getCode().equals(code.getCode())){
            throw new BadRequestException("无效验证码");
        } else {
            verificationCode.setStatus(false);
            verificationCodeRepository.save(verificationCode);
        }
    }

    /**
     * 定时任务，指定分钟后改变验证码状态
     * @param verifyCode
     */
    private void timedDestruction(VerificationCode verifyCode) {
        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        // 以下示例为程序调用结束继续启动该定时任务，会延迟60s启动，一共配置了两个线程ThreadPoolUtil中设置
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        try {
            executorService.schedule(() -> {
                verifyCode.setStatus(false);
                verificationCodeRepository.save(verifyCode);
            }, expiration * 60 * 1000L, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
