package com.sinovatio.modules.security.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

/**
* @ClassName: AuthenticationInfo
* @Description: 认证信息
* @Author JinLu
* @Date 2019/4/19 15:38
* @Version 1.0
*/
@Getter
@AllArgsConstructor
public class AuthenticationInfo implements Serializable {

    private final String token;

    private final JwtUser user;
}
