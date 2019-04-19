package com.sinovatio.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
* @ClassName: UserDTO
* @Description: 用户DTO
* @Author JinLu
* @Date 2019/4/19 15:54
* @Version 1.0
*/
@Data
public class UserDTO implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String phone;

    private Boolean enabled;

    @JsonIgnore
    private String password;

    private Timestamp createTime;

    private Date lastPasswordResetTime;

    @ApiModelProperty(hidden = true)
    private Set<RoleDTO> roles;

    @ApiModelProperty(hidden = true)
    private JobDTO job;

    private DeptDTO dept;

    private Long deptId;
}
