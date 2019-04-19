package com.sinovatio.modules.system.service.query;

import com.sinovatio.modules.system.domain.Role;
import com.sinovatio.modules.system.repository.RoleRepository;
import com.sinovatio.modules.system.service.mapper.RoleMapper;
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
* @ClassName: RoleQueryService
* @Description: 角色查询服务
* @Author JinLu
* @Date 2019/4/19 15:58
* @Version 1.0
*/
@Service
@CacheConfig(cacheNames = "role")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleQueryService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(String name, Pageable pageable){
        Page<Role> page = roleRepository.findAll(new Spec(name),pageable);
        return PageUtil.toPage(page.map(roleMapper::toDto));
    }

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(){
        List<Role> roles = roleRepository.findAll(new Spec(null));
        return roleMapper.toDto(roles);
    }

    class Spec implements Specification<Role> {

        private String name;

        public Spec(String name){
            this.name = name;
        }

        @Override
        public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

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
