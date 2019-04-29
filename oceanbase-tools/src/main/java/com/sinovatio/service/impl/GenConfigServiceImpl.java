package com.sinovatio.service.impl;

import com.sinovatio.domain.GenConfig;
import com.sinovatio.repository.GenConfigRepository;
import com.sinovatio.service.GenConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
* @ClassName: GenConfigServiceImpl
* @Description: 代码生成配置服务
* @Author JinLu
* @Date 2019/4/19 14:26
* @Version 1.0
*/
@Service
public class GenConfigServiceImpl implements GenConfigService {

    @Autowired
    private GenConfigRepository genConfigRepository;

    @Override
    public GenConfig find() {
        Optional<GenConfig> genConfig = genConfigRepository.findById(1L);
        if(genConfig.isPresent()){
            return genConfig.get();
        } else {
            return new GenConfig();
        }
    }

    @Override
    public GenConfig update(GenConfig genConfig) {
        genConfig.setId(1L);
        return genConfigRepository.save(genConfig);
    }
}
