package com.sinovatio.modules.security.service;

import com.sinovatio.exception.EntityNotFoundException;
import com.sinovatio.modules.security.security.JwtUser;
import com.sinovatio.modules.system.domain.Permission;
import com.sinovatio.modules.system.domain.Role;
import com.sinovatio.modules.system.domain.User;
import com.sinovatio.modules.system.repository.UserRepository;
import com.sinovatio.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @ClassName: JwtUserDetailsService
* @Description: 用户认证信息，重写loadUserByUsername方法
* @Author JinLu
* @Date 2019/4/3 16:55
* @Version 1.0
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){

        User user = null;
        if(ValidationUtil.isEmail(username)){
            user = userRepository.findByEmail(username);
        } else {
            user = userRepository.findByUsername(username);
        }

        if (user == null) {
            throw new EntityNotFoundException(User.class, "name", username);
        } else {
            return create(user);
        }
    }

    public UserDetails create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getEnabled(),
                user.getCreateTime(),
                user.getLastPasswordResetTime()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> roles) {

        Set<Permission> permissions = new HashSet<>();
        for (Role role : roles) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);
            permissions.addAll(role.getPermissions());
        }

        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority("ROLE_"+permission.getName()))
                .collect(Collectors.toList());
    }
}
