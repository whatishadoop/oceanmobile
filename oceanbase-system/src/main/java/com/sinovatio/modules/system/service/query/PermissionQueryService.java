package com.sinovatio.modules.system.service.query;

import com.sinovatio.modules.system.domain.Permission;
import com.sinovatio.modules.system.repository.PermissionRepository;
import com.sinovatio.modules.system.service.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
* @ClassName: PermissionQueryService
* @Description: 权限查询服务
* @Author JinLu
* @Date 2019/4/19 15:58
* @Version 1.0
*/
@Service
@CacheConfig(cacheNames = "permission")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PermissionQueryService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 不分页
     */
    @Cacheable(key = "'queryAll:'+#p0")
    public List queryAll(String name){
        return permissionMapper.toDto(permissionRepository.findAll(new Spec(name)));
    }

    class Spec implements Specification<Permission> {

        private String name;

        public Spec(String name) {
            this.name = name;
        }

        @Override
        public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(name)){
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class),"%"+name+"%"));
            }

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
