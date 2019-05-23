package com.sinovatio.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author admin
* @date 2019-05-21
*/
@Entity
@Data
@Table(name="app_busi_solution")
public class AppBusiSolution implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * create_time
     */
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * enabled
     */
    @Column(name = "enabled",nullable = false)
    private Boolean enabled;

    /**
     * name
     */
    @Column(name = "name",nullable = false)
    private String name;

    /**
     * pid
     */
    @Column(name = "pid",nullable = false)
    private Long pid;
}