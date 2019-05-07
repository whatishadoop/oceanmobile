package com.sinovatio.service.impl;

import com.sinovatio.domain.AppPage;
import com.sinovatio.repository.AppPageRepository;
import com.sinovatio.service.AppPageService;
import com.sinovatio.service.dto.AppPageDTO;
import com.sinovatio.service.mapper.AppPageMapper;
import com.sinovatio.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @ClassName: AppPageServiceImpl
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 14:26
 * @Version 1.0
 */
@Service
@Transactional( propagation = Propagation.SUPPORTS, rollbackFor =  Exception.class)
public class AppPageServiceImpl implements AppPageService {

    @Autowired
    private AppPageRepository appPageRepository;

    @Autowired
    private AppPageMapper appPageMapper;

    @Override
    public AppPageDTO findById(Long id) {
        Optional<AppPage> appPageOptional = appPageRepository.findById(id);
        ValidationUtil.isNull(appPageOptional,"AppPage","id",id);
        return appPageMapper.toDto(appPageOptional.get());
    }

    @Override
    public AppPageDTO create(AppPage appPage) {
        return appPageMapper.toDto(appPageRepository.save(appPage));
    }

    @Override
    public void update(AppPage appPage) {
       Optional<AppPage> appPageOptional = appPageRepository.findById(appPage.getId());
       ValidationUtil.isNull(appPageOptional,"AppPage","id",appPage.getId());

       AppPage tmpAppPage = appPageOptional.get();
       // 对appPage对象进行修改
       appPageRepository.save(tmpAppPage);
    }

    @Override
    public void delete(Long id) {
        appPageRepository.deleteById(id);
    }
}
