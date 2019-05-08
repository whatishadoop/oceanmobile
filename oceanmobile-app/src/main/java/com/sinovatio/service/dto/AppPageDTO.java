package com.sinovatio.service.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName: AppPageDTO
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 10:07
 * @Version 1.0
 */
@Data
public class AppPageDTO {
    private Long id;

    private String name;

    private String code;

    private String content;

    private String contentParse;

    private String config;

    private String isEnable;

    private String creator;

    private Timestamp createTime;
}
