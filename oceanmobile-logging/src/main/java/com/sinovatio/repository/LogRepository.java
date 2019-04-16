package com.sinovatio.repository;

import com.sinovatio.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**  
* @ClassName: LogRepository
* @Description: 日志数据查询
* @Author JinLu
* @Date 2019/4/3 15:00
* @Version 1.0
*/
@Repository
public interface LogRepository extends JpaRepository<Log,Long>, JpaSpecificationExecutor {
    /**
     * @Author JinLu
     * @Description: 获取一个时间段的IP记录
     * @param date1 开始时间
     * @param date2 结束时间
     * @Return java.lang.Long
     * @Date 2019/4/3 15:02
     */
    @Query(value = "select count(*) FROM (select request_ip FROM log where create_time between ?1 and ?2 GROUP BY request_ip) as s",nativeQuery = true)
    Long findIp(String date1, String date2);
}
