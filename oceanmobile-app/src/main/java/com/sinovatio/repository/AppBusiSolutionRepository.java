package com.sinovatio.repository;

import com.sinovatio.domain.AppBusiSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author admin
* @date 2019-05-21
*/
public interface AppBusiSolutionRepository extends JpaRepository<AppBusiSolution, Long>, JpaSpecificationExecutor {
}