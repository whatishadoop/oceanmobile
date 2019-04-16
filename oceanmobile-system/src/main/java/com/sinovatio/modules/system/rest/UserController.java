package com.sinovatio.modules.system.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.domain.Picture;
import com.sinovatio.domain.VerificationCode;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.modules.security.security.JwtUser;
import com.sinovatio.modules.security.utils.JwtTokenUtil;
import com.sinovatio.modules.system.domain.User;
import com.sinovatio.modules.system.service.UserService;
import com.sinovatio.modules.system.service.dto.UserDTO;
import com.sinovatio.modules.system.service.query.UserQueryService;
import com.sinovatio.service.PictureService;
import com.sinovatio.service.VerificationCodeService;
import com.sinovatio.utils.ElAdminConstant;
import com.sinovatio.utils.EncryptUtils;
import com.sinovatio.utils.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MenuController
 * @Description: 用户服务接口
 * @Author JinLu
 * @Date 2019/4/3 17:06
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private VerificationCodeService verificationCodeService;


    private static final String ENTITY_NAME = "user";

    /**
     * @Author JinLu
     * @Description: 根据id查询单个用户
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:09
    */
    @GetMapping(value = "/users/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT')")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 查询多个用户
     * @param userDTO
     * @param pageable
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:09
    */
    @Log("查询用户")
    @GetMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT')")
    public ResponseEntity getUsers(UserDTO userDTO, Pageable pageable){
        return new ResponseEntity(userQueryService.queryAll(userDTO,pageable),HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 新增用户
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:08
    */
    @Log("新增用户")
    @PostMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody User resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(userService.create(resources),HttpStatus.CREATED);
    }

    /**
     * @Author JinLu
     * @Description: 修改用户
     * @param resources
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:08
    */
    @Log("修改用户")
    @PutMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody User resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        userService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * @Author JinLu
     * @Description: 删除用户
     * @param id
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:08
    */
    @Log("删除用户")
    @DeleteMapping(value = "/users/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 验证密码
     * @param pass
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:08
    */
    @GetMapping(value = "/users/validPass/{pass}")
    public ResponseEntity validPass(@PathVariable String pass){
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        JwtUser jwtUser = (JwtUser)userDetailsService.loadUserByUsername(userDetails.getUsername());
        Map map = new HashMap();
        map.put("status",200);
        if(!jwtUser.getPassword().equals(EncryptUtils.encryptPassword(pass))){
           map.put("status",400);
        }
        return new ResponseEntity(map,HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 修改密码
     * @param pass
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:07
    */
    @GetMapping(value = "/users/updatePass/{pass}")
    public ResponseEntity updatePass(@PathVariable String pass){
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        JwtUser jwtUser = (JwtUser)userDetailsService.loadUserByUsername(userDetails.getUsername());
        if(jwtUser.getPassword().equals(EncryptUtils.encryptPassword(pass))){
            throw new BadRequestException("新密码不能与旧密码相同");
        }
        userService.updatePass(jwtUser,EncryptUtils.encryptPassword(pass));
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 修改头像
     * @param file
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:07
    */
    @PostMapping(value = "/users/updateAvatar")
    public ResponseEntity updateAvatar(@RequestParam MultipartFile file){
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        JwtUser jwtUser = (JwtUser)userDetailsService.loadUserByUsername(userDetails.getUsername());
        Picture picture = pictureService.upload(file,jwtUser.getUsername());
        userService.updateAvatar(jwtUser,picture.getUrl());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 修改邮箱
     * @param code
     * @param user
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 17:06
    */
    @PostMapping(value = "/users/updateEmail/{code}")
    public ResponseEntity updateEmail(@PathVariable String code,@RequestBody User user){
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        JwtUser jwtUser = (JwtUser)userDetailsService.loadUserByUsername(userDetails.getUsername());
        if(!jwtUser.getPassword().equals(EncryptUtils.encryptPassword(user.getPassword()))){
            throw new BadRequestException("密码错误");
        }
        VerificationCode verificationCode = new VerificationCode(code, ElAdminConstant.RESET_MAIL,"email",user.getEmail());
        verificationCodeService.validated(verificationCode);
        userService.updateEmail(jwtUser,user.getEmail());
        return new ResponseEntity(HttpStatus.OK);
    }
}
