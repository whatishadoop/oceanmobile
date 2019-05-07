package com.sinovatio.service.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName: ApplicationDTO
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 10:06
 * @Version 1.0
 */
@Data
public class ApplicationDTO {

    private Long id;

    private String name;

    private String code;

    private String busiName;

    private String creator;

    private Timestamp createTime;

    private String description;

    private Long sort;
}
