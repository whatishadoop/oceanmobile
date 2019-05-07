package com.sinovatio.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Entity
@Table( name = "app_page")
public class AppPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotBlank
    @Column ( columnDefinition = "longtext")
    private String config;

    @NotBlank
    @Column
    private String isEnable;

    @NotBlank
    @Column
    private String creator;

    @CreationTimestamp
    @Column( name = "create_time")
    private Timestamp createTime;

    @NotBlank
    @Column
    private Long sort;

    @NotBlank
    @Column
    private String remark;
}
