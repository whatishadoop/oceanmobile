package com.sinovatio.repository;

import com.sinovatio.domain.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: VerificationCodeRepository
* @Description: 验证码校验操作jpa
* @Author JinLu
* @Date 2019/4/19 16:12
* @Version 1.0
*/
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {

    /**
     * 获取有效的验证码
     * @param scenes 业务场景，如重置密码，重置邮箱等等
     * @param type
     * @param value
     * @return
     */
    VerificationCode findByScenesAndTypeAndValueAndStatusIsTrue(String scenes, String type, String value);
}
