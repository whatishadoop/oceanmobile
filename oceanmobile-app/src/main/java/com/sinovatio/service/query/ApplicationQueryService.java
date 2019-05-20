package com.sinovatio.service.query;

import com.sinovatio.domain.Application;
import com.sinovatio.repository.ApplicationRepository;
import com.sinovatio.service.dto.ApplicationDTO;
import com.sinovatio.utils.PageUtil;
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

/**
 * @ClassName: ApplicationQueryService
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/6 16:18
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames = "application")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ApplicationQueryService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ApplicationDTO applicationDTO, Pageable pageable){
        Page page = applicationRepository.findAll(new Spec(applicationDTO),pageable);
        return PageUtil.toPage(page);
    }

    private class Spec implements Specification<Application> {
        private ApplicationDTO applicationDTO = null;

        public Spec(ApplicationDTO applicationDTO) {
            this.applicationDTO = applicationDTO;
        }

        @Override
        public Predicate toPredicate(Root<Application> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
            List<Predicate> list = new ArrayList<>();
            // 拼接查询条件
            if(!ObjectUtils.isEmpty(applicationDTO.getName())){
                list.add(cb.like(root.get("name").as(String.class),"%" + applicationDTO.getName() + "%"));
            }
            if(!ObjectUtils.isEmpty(applicationDTO.getEnabled())){
                /**
                 * 精确
                 */
                list.add(cb.equal(root.get("enabled").as(Boolean.class),applicationDTO.getEnabled()));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
