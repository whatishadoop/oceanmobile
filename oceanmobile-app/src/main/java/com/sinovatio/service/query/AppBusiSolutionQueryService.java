package com.sinovatio.service.query;

import com.sinovatio.utils.PageUtil;
import com.sinovatio.domain.AppBusiSolution;
import com.sinovatio.service.dto.AppBusiSolutionDTO;
import com.sinovatio.repository.AppBusiSolutionRepository;
import com.sinovatio.service.mapper.AppBusiSolutionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
* @author admin
* @date 2019-05-21
*/
@Service
@CacheConfig(cacheNames = "appBusiSolution")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppBusiSolutionQueryService {

    @Autowired
    private AppBusiSolutionRepository appBusiSolutionRepository;

    @Autowired
    private AppBusiSolutionMapper appBusiSolutionMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AppBusiSolutionDTO appBusiSolution, Pageable pageable){
        Page<AppBusiSolution> page = appBusiSolutionRepository.findAll(new Spec(appBusiSolution),pageable);
        return PageUtil.toPage(page.map(appBusiSolutionMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public List<AppBusiSolutionDTO> queryAll(AppBusiSolutionDTO appBusiSolution){
        return appBusiSolutionMapper.toDto(appBusiSolutionRepository.findAll(new Spec(appBusiSolution)));
    }

    class Spec implements Specification<AppBusiSolution> {

        private AppBusiSolutionDTO appBusiSolution;

        public Spec(AppBusiSolutionDTO appBusiSolution){
            this.appBusiSolution = appBusiSolution;
        }

        @Override
        public Predicate toPredicate(Root<AppBusiSolution> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(appBusiSolution.getCreateTime())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("create_time").as(Timestamp.class),appBusiSolution.getCreateTime()));
            }
            if(!ObjectUtils.isEmpty(appBusiSolution.getName())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("name").as(String.class),"%"+appBusiSolution.getName()+"%"));
            }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}