package com.sinovatio.service.impl;

import com.sinovatio.domain.Application;
import com.sinovatio.repository.ApplicationRepository;
import com.sinovatio.service.ApplicationService;
import com.sinovatio.service.dto.ApplicationDTO;
import com.sinovatio.service.mapper.ApplicationMapper;
import com.sinovatio.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @ClassName: ApplicationServiceImpl
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 11:22
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public ApplicationDTO findById(long id) {
        Optional<Application> application =  applicationRepository.findById(id);
        ValidationUtil.isNull(application,"Application","id",id);
        return applicationMapper.toDto(application.get());
    }

    @Override
    public ApplicationDTO create(Application application) {
        return applicationMapper.toDto(applicationRepository.save(application));
    }

    @Override
    public void update(Application application) {
        Optional<Application> applicationOptional = applicationRepository.findById(application.getId());
        ValidationUtil.isNull(applicationOptional, "Application", "id",application.getId());
        // 此处需修改相关属性信息
        Application tmpApplication = applicationOptional.get();
        tmpApplication.setBusiName(application.getBusiName());
        tmpApplication.setCode(application.getCode());
        tmpApplication.setDescription(application.getDescription());
        tmpApplication.setCreator(application.getCreator());
        tmpApplication.setEnabled(application.getEnabled());
        tmpApplication.setSort(application.getSort());
        applicationRepository.save(tmpApplication);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        applicationRepository.deleteById(id);
    }
}
