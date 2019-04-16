package com.sinovatio.modules.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
* @ClassName: MenuDTO
* @Description: 菜单DTO
* @Author JinLu
* @Date 2019/4/3 17:15
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

    private Set<RoleDTO> roles;

    private List<MenuDTO> children;

    private Timestamp createTime;
}
