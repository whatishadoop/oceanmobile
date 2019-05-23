package com.sinovatio.service.impl;

import com.sinovatio.domain.AppBusiSolution;
import com.sinovatio.repository.AppBusiSolutionRepository;
import com.sinovatio.service.AppBusiSolutionService;
import com.sinovatio.service.dto.AppBusiSolutionDTO;
import com.sinovatio.service.mapper.AppBusiSolutionMapper;
import com.sinovatio.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
* @author admin
* @date 2019-05-21
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppBusiSolutionServiceImpl implements AppBusiSolutionService {

    @Autowired
    private AppBusiSolutionRepository appBusiSolutionRepository;

    @Autowired
    private AppBusiSolutionMapper appBusiSolutionMapper;

    @Override
    public AppBusiSolutionDTO findById(Long id) {
        Optional<AppBusiSolution> appBusiSolution = appBusiSolutionRepository.findById(id);
        ValidationUtil.isNull(appBusiSolution,"AppBusiSolution","id",id);
        return appBusiSolutionMapper.toDto(appBusiSolution.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppBusiSolutionDTO create(AppBusiSolution resources) {
        return appBusiSolutionMapper.toDto(appBusiSolutionRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AppBusiSolution resources) {
        Optional<AppBusiSolution> optionalAppBusiSolution = appBusiSolutionRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAppBusiSolution,"AppBusiSolution","id",resources.getId());

        AppBusiSolution appBusiSolution = optionalAppBusiSolution.get();
        // 此处需自己修改
        resources.setId(appBusiSolution.getId());
        appBusiSolutionRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        appBusiSolutionRepository.deleteById(id);
    }

    @Override
    public Object buildTree(List<AppBusiSolutionDTO> appBusiSolutionDTOS) {
        Set<AppBusiSolutionDTO> trees = new LinkedHashSet<>();
        Set<AppBusiSolutionDTO> appBusiSolutions = new LinkedHashSet<>();
        Boolean isChild;
        for (AppBusiSolutionDTO appBusiSolutionDTO : appBusiSolutionDTOS) {
            isChild = false;
            if ("0".equals(appBusiSolutionDTO.getPid().toString())) {
                trees.add(appBusiSolutionDTO);
            }
            for (AppBusiSolutionDTO it : appBusiSolutionDTOS) {
                if (it.getPid().equals(appBusiSolutionDTO.getId())) {
                    isChild = true;
                    if (appBusiSolutionDTO.getChildren() == null) {
                        appBusiSolutionDTO.setChildren(new ArrayList<AppBusiSolutionDTO>());
                    }
                    appBusiSolutionDTO.getChildren().add(it);
                }
            }
            if(isChild) {
                appBusiSolutions.add(appBusiSolutionDTO);
            }
        }

        if (CollectionUtils.isEmpty(trees)) {
            trees = appBusiSolutions;
        }

        Integer totalElements = appBusiSolutionDTOS!=null?appBusiSolutionDTOS.size():0;

        Map map = new HashMap();
        map.put("totalElements",totalElements);
        map.put("content",CollectionUtils.isEmpty(trees)?appBusiSolutionDTOS:trees);
        return map;
    }
}