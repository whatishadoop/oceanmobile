package com.sinovatio.repository;

import com.sinovatio.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: EmailRepository
* @Description: email操作jpa
* @Author JinLu
* @Date 2019/4/19 16:11
* @Version 1.0
*/
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
