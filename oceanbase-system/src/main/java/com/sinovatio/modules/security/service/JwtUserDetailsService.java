package com.sinovatio.modules.security.service;

import com.sinovatio.exception.EntityNotFoundException;
import com.sinovatio.modules.security.security.JwtUser;
import com.sinovatio.modules.system.domain.Dept;
import com.sinovatio.modules.system.domain.Job;
import com.sinovatio.modules.system.domain.User;
import com.sinovatio.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @ClassName: JwtUserDetailsService
* @Description: 用户认证服务
* @Author JinLu
* @Date 2019/4/19 15:42
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username){

        User user = userService.findByName(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, "name", username);
        } else {
            return createJwtUser(user);
        }
    }

    public UserDetails createJwtUser(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                user.getPhone(),
                Optional.ofNullable(user.getDept()).map(Dept::getName).orElse(null),
                Optional.ofNullable(user.getJob()).map(Job::getName).orElse(null),
                permissionService.mapToGrantedAuthorities(user),//将用户角色作为权限
                user.getEnabled(),
                user.getCreateTime(),
                user.getLastPasswordResetTime()
        );
    }
}
