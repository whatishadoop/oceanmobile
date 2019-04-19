package com.sinovatio.repository;

import com.sinovatio.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: AlipayRepository
* @Description: 阿里支付jpa操作
* @Author JinLu
* @Date 2019/4/19 16:10
* @Version 1.0
*/
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}
