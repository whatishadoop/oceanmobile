package com.sinovatio.modules.system.domain;

import lombok.Data;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @ClassName: Job
* @Description: 定时任务对象
* @Author JinLu
* @Date 2019/4/19 15:45
* @Version 1.0
*/
@Entity
@Data
@Table(name="job")
public class Job implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    @Column(unique = true)
    @NotNull
    private Long sort;

    /**
     * 状态
     */
    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    public @interface Update {}
}