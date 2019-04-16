package com.sinovatio.modules.monitor.repository;

import com.sinovatio.modules.monitor.domain.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @ClassName: VisitsRepository
* @Description: 用户访问业务统计
* @Author JinLu
* @Date 2019/4/3 16:11
* @Version 1.0
*/
@Repository
public interface VisitsRepository extends JpaRepository<Visits,Long> {

   /**
    * @Author JinLu
    * @Description: 根据指定时间查找访问信息
    * @Return
    * @Date 2019/4/3 16:12
   */
    Visits findByDate(String date);

    /**
     * @Author JinLu
     * @Description: 获得一个时间段的访问记录
     * @Return
     * @Date 2019/4/3 16:12
    */
    @Query(value = "select * FROM visits where " +
            "create_time between ?1 and ?2",nativeQuery = true)
    List<Visits> findAllVisits(String date1, String date2);
}
