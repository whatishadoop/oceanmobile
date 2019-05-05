package com.sinovatio.repository;

import com.sinovatio.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApplicationRepository extends JpaRepository<Application,Long>, JpaSpecificationExecutor {

}
