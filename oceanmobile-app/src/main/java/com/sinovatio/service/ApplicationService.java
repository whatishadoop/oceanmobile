package com.sinovatio.service;

import com.sinovatio.domain.Application;
import com.sinovatio.service.dto.ApplicationDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @ClassName: ApplicationService
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/6 16:17
 * @Version 1.0
 */
@CacheConfig( cacheNames = "application")
public interface ApplicationService {

    @Cacheable (key = "#p0")
    ApplicationDTO findById(long id);

    @CacheEvict (allEntries = true)
    ApplicationDTO create(Application application);

    @CacheEvict (allEntries = true)
    void update(Application application);

    @CacheEvict (allEntries = true)
    void delete(Long id);

}
