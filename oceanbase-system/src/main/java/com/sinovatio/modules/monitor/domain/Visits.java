package com.sinovatio.modules.monitor.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
* @ClassName: Visits
* @Description: pv 与 ip 统计
* @Author JinLu
* @Date 2019/4/19 14:34
* @Version 1.0
*/
@Entity
@Data
@Table(name = "sys_visits")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String date;

    @Column(name = "pv_counts")
    private Long pvCounts;

    @Column(name = "ip_counts")
    private Long ipCounts;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "week_day")
    private String weekDay;
}
