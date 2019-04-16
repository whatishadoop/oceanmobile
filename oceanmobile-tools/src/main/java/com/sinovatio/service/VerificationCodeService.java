package com.sinovatio.service;

import com.sinovatio.domain.VerificationCode;
import com.sinovatio.domain.vo.EmailVo;

/**
* @ClassName: VerificationCodeService
* @Description: 验证码服务
* @Author JinLu
* @Date 2019/4/4 10:46
* @Version 1.0
*/
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code
     */
    void validated(VerificationCode code);
}
