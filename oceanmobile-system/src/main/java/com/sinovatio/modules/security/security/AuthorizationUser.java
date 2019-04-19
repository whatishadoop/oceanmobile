package com.sinovatio.modules.security.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: AuthorizationUser
* @Description: 认证用户
* @Author JinLu
* @Date 2019/4/19 15:38
* @Version 1.0
*/
@Getter
@Setter
public class AuthorizationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Override
    public String toString() {
        return "{username=" + username  + ", password= ******}";
    }
}
