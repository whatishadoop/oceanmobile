package com.sinovatio.modules.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
* @ClassName: MenuDTO
* @Description: 菜单DTO
* @Author JinLu
* @Date 2019/4/19 15:53
* @Version 1.0
*/
@Data
public class MenuDTO {

    private Long id;

    private String name;

    private Long sort;

    private String path;

    private String component;

    private Long pid;

    private Boolean iFrame;

    private String icon;

    private List<MenuDTO> children;

    private Timestamp createTime;
}
