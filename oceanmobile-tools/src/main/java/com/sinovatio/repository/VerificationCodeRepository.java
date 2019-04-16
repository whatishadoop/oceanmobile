package com.sinovatio.repository;

import com.sinovatio.domain.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: VerificationCodeRepository
* @Description: 记录验证码
* @Author JinLu
* @Date 2019/4/3 17:35
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
