package com.sinovatio.service;

import com.sinovatio.domain.AppBusiSolution;
import com.sinovatio.service.dto.AppBusiSolutionDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
* @author admin
* @date 2019-05-21
*/
@CacheConfig(cacheNames = "appBusiSolution")
public interface AppBusiSolutionService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    AppBusiSolutionDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AppBusiSolutionDTO create(AppBusiSolution resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(AppBusiSolution resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    @Cacheable(keyGenerator = "keyGenerator")
    Object buildTree(List<AppBusiSolutionDTO> appBusiSolutionDTOS);
}