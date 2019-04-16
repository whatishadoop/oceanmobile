package com.sinovatio.repository;

import com.sinovatio.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: EmailRepository
* @Description: 邮件配置
* @Author JinLu
* @Date 2019/4/3 17:33
* @Version 1.0
*/
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
