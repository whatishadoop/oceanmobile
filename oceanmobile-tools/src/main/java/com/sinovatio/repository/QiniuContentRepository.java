package com.sinovatio.repository;

import com.sinovatio.domain.QiniuContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QiniuContentRepository extends JpaRepository<QiniuContent,Long>, JpaSpecificationExecutor {

    /**
     * 根据key查询
     * @param key
     * @return
     */
    QiniuContent findByKey(String key);
}
