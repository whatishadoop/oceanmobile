package com.sinovatio.repository;

import com.sinovatio.domain.FileContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FileContentRepository extends JpaRepository<FileContent,Long>, JpaSpecificationExecutor {

    /**
     * 根据key查询
     * @param key
     * @return
     */
    FileContent findByKey(String key);
}
