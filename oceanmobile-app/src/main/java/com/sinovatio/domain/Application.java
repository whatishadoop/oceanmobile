package com.sinovatio.domain;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table( name = "app_application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    private String name;

    //@NotBlank
    private String code;
    @NotBlank
    @Column(name = "busi_name")
    private String busiName;

    //@NotBlank
    private String creator;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    //@NotBlank
    private String description;

    @NotNull
    private Long sort;

    @NotNull
    private Boolean enabled;

    public interface  Update{}
}
