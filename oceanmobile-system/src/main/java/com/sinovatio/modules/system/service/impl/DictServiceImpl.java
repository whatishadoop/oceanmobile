package com.sinovatio.modules.system.service.impl;

import com.sinovatio.modules.system.domain.Dict;
import com.sinovatio.utils.ValidationUtil;
import com.sinovatio.modules.system.repository.DictRepository;
import com.sinovatio.modules.system.service.DictService;
import com.sinovatio.modules.system.service.dto.DictDTO;
import com.sinovatio.modules.system.service.mapper.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @ClassName: DictServiceImpl
* @Description: 字典服务
* @Author JinLu
* @Date 2019/4/19 15:54
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {

    @Autowired
    private DictRepository dictRepository;

    @Autowired
    private DictMapper dictMapper;

    @Override
    public DictDTO findById(Long id) {
        Optional<Dict> dict = dictRepository.findById(id);
        ValidationUtil.isNull(dict,"Dict","id",id);
        return dictMapper.toDto(dict.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictDTO create(Dict resources) {
        return dictMapper.toDto(dictRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Dict resources) {
        Optional<Dict> optionalDict = dictRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalDict,"Dict","id",resources.getId());

        Dict dict = optionalDict.get();
        // 此处需自己修改
        resources.setId(dict.getId());
        dictRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictRepository.deleteById(id);
    }
}