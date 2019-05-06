package com.sinovatio.service.query;

import com.sinovatio.domain.AppPage;
import com.sinovatio.repository.AppPageRepository;
import com.sinovatio.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
 * @ClassName: AppPageQueryService
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/6 16:18
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames = "apppage")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppPageQueryService {

    @Autowired
    private AppPageRepository appPageRepository;

    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AppPage appPage, Pageable pageable){
        return PageUtil.toPage(appPageRepository.findAll(new Spec(appPage),pageable));
    }

    private class Spec implements Specification {
        private AppPage appPage = null;
        public Spec(AppPage appPage) {
            this.appPage = appPage;
        }

        @Override
        public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();
            if(!ObjectUtils.isEmpty(appPage.getContent())){
                list.add(cb.like(root.get("key").as(String.class),"%"+ appPage.getContent()+"%"));
            }
            // 转换成Predicate 对象条件数组形式
            Predicate[] p = new Predicate[list.size()];
            // 将list转换成数组，条件之间是and关系
            return cb.and(list.toArray(p));
        }
    }
}
