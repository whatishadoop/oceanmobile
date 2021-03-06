package com.sinovatio.modules.system.service.query;

import com.sinovatio.utils.PageUtil;
import com.sinovatio.modules.system.domain.Dict;
import com.sinovatio.modules.system.service.dto.DictDTO;
import com.sinovatio.modules.system.repository.DictRepository;
import com.sinovatio.modules.system.service.mapper.DictMapper;
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
* @ClassName: DictQueryService
* @Description: 字典查询服务
* @Author JinLu
* @Date 2019/4/19 15:57
* @Version 1.0
*/
@Service
@CacheConfig(cacheNames = "dict")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictQueryService {

    @Autowired
    private DictRepository dictRepository;

    @Autowired
    private DictMapper dictMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DictDTO dict, Pageable pageable){
        Page<Dict> page = dictRepository.findAll(new Spec(dict),pageable);
        return PageUtil.toPage(page.map(dictMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DictDTO dict){
        return dictMapper.toDto(dictRepository.findAll(new Spec(dict)));
    }

    class Spec implements Specification<Dict> {

        private DictDTO dict;

        public Spec(DictDTO dict){
            this.dict = dict;
        }

        @Override
        public Predicate toPredicate(Root<Dict> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(dict.getName())){
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class),"%"+dict.getName()+"%"));
            }
            if(!ObjectUtils.isEmpty(dict.getRemark())){
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("remark").as(String.class),"%"+dict.getRemark()+"%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}