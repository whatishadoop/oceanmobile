package com.sinovatio.modules.quartz.service.query;

import com.sinovatio.modules.quartz.domain.QuartzLog;
import com.sinovatio.modules.quartz.repository.QuartzLogRepository;
import com.sinovatio.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
* @ClassName: QuartzLogQueryService
* @Description: 定时任务日志查询
* @Author JinLu
* @Date 2019/4/19 14:42
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class QuartzLogQueryService {

    @Autowired
    private QuartzLogRepository quartzLogRepository;

    public Object queryAll(QuartzLog quartzLog, Pageable pageable){
        return PageUtil.toPage(quartzLogRepository.findAll(new Spec(quartzLog),pageable));
    }

    class Spec implements Specification<QuartzLog> {

        private QuartzLog quartzLog;

        public Spec(QuartzLog quartzLog){
            this.quartzLog = quartzLog;
        }

        @Override
        public Predicate toPredicate(Root<QuartzLog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(quartzLog.getJobName())){

                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("jobName").as(String.class),"%"+quartzLog.getJobName()+"%"));
            }

            if (!ObjectUtils.isEmpty(quartzLog.getIsSuccess())) {
                list.add(cb.equal(root.get("isSuccess").as(Boolean.class), quartzLog.getIsSuccess()));
            }

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
