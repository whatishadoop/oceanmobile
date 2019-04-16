package com.sinovatio.modules.system.service.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @Author JinLu
 * @Description: 角色DTO
 * @param null
 * @Return
 * @Date 2019/4/3 17:15
*/
@Data
public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    private String remark;

    private Set<PermissionDTO> permissions;

    private Timestamp createTime;
}
