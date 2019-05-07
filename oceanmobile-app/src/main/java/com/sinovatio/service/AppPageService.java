package com.sinovatio.service;

import com.sinovatio.domain.AppPage;
import com.sinovatio.service.dto.AppPageDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @ClassName: AppPageService
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/6 16:17
 * @Version 1.0
 */
@CacheConfig (cacheNames = "apppage")
public interface AppPageService {

    @Cacheable(key = "#p0")
    AppPageDTO findById(Long id);

    @CacheEvict(allEntries = true)
    AppPageDTO create(AppPage appPage);

    @CacheEvict(allEntries = true)
    void update(AppPage appPage);

    @CacheEvict(allEntries = true)
    void delete(Long id);
}
