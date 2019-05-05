package com.sinovatio.domain;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Entity
@Table( name = "app_application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;
    @NotBlank
    @Column(name = "busi_name")
    private String busiName;

    @NotBlank
    private String creator;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    @NotBlank
    private String description;

    @NotBlank
    private Long sort;

}
