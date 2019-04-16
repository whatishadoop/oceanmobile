package com.sinovatio.repository;

import com.sinovatio.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: AlipayRepository
* @Description: 阿里支付配置
* @Author JinLu
* @Date 2019/4/3 17:32
* @Version 1.0
*/
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}
