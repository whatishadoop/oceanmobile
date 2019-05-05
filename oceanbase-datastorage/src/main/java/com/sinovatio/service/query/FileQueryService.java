package com.sinovatio.service.query;

import com.sinovatio.domain.FileContent;
import com.sinovatio.repository.FileContentRepository;
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
* @ClassName: QiNiuQueryService
* @Description: 文件云查询服务
* @Author JinLu
* @Date 2019/4/19 16:16
* @Version 1.0
*/
@Service
@CacheConfig(cacheNames = "qiNiu")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FileQueryService {

    @Autowired
    private FileContentRepository fileContentRepository;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(FileContent fileContent, Pageable pageable){
        return PageUtil.toPage(fileContentRepository.findAll(new Spec(fileContent),pageable));
    }

    class Spec implements Specification<FileContent> {
        private FileContent fileContent;

        public Spec(FileContent fileContent){
            this.fileContent = fileContent;
        }

        @Override
        public Predicate toPredicate(Root<FileContent> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();
            // 组装查询条件
            if(!ObjectUtils.isEmpty(fileContent.getKey())){
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("key").as(String.class),"%"+ fileContent.getKey()+"%"));
            }

            // 转换成Predicate 对象条件数组形式
            Predicate[] p = new Predicate[list.size()];
            // 将list转换成数组，条件之间是and关系
            return cb.and(list.toArray(p));
        }
    }
}
