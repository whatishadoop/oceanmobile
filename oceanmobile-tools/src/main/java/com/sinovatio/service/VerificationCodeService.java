package com.sinovatio.service;

import com.sinovatio.domain.VerificationCode;
import com.sinovatio.domain.vo.EmailVo;

/**
 * @author jie
 * @date 2018-12-26
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
