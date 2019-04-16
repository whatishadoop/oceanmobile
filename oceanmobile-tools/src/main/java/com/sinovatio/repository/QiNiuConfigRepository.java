package com.sinovatio.repository;

import com.sinovatio.domain.QiniuConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @ClassName: QiNiuConfigRepository
* @Description: 存储配置
* @Author JinLu
* @Date 2019/4/3 17:34
* @Version 1.0
*/
public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig,Long> {
}
