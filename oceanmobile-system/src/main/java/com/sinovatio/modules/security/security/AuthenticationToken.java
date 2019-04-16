package com.sinovatio.modules.security.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
* @ClassName: AuthenticationToken
* @Description: 令牌对象
* @Author JinLu
* @Date 2019/4/3 16:51
* @Version 1.0
*/
@Getter
@AllArgsConstructor
public class AuthenticationToken implements Serializable {
    private final String token;
}
