package com.sinovatio.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table( name = "app_page")
public class AppPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String code;

    @NotBlank
    @Column ( columnDefinition = "longtext")
    private String content;

    @NotBlank
    @Column ( name = "content_parse", columnDefinition = "longtext")
    private String contentParse;

    // 页面所有配置内容
    @NotBlank
    @Column ( columnDefinition = "longtext")
    private String config;

    @NotNull
    private Boolean enabled;

    @NotBlank
    @Column
    private String creator;

    @CreationTimestamp
    @Column( name = "create_time")
    private Timestamp createTime;

    @NotNull
    @Column
    private Long sort;

    @NotBlank
    @Column
    private String remark;

    public interface  Update{}
}
