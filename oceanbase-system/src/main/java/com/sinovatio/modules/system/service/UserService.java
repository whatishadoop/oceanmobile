package com.sinovatio.modules.system.service;

import com.sinovatio.modules.system.domain.User;
import com.sinovatio.modules.system.service.dto.UserDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @ClassName: UserService
* @Description: 用户服务
* @Author JinLu
* @Date 2019/4/19 16:00
* @Version 1.0
*/
@CacheConfig(cacheNames = "user")
public interface UserService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    UserDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     * 清除缓存中以user缓存策略缓存的所有对象，避免数据库中删除，而缓存中依然存在
     */
    @CacheEvict(allEntries = true)
    UserDTO create(User resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(User resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * findByName
     * @param userName
     * @return
     */
    @Cacheable(key = "'loadUserByUsername:'+#p0")
    User findByName(String userName);

    /**
     * 修改密码
     * @param username
     * @param encryptPassword
     */
    @CacheEvict(allEntries = true)
    void updatePass(String username, String encryptPassword);

    /**
     * 修改头像
     * @param username
     * @param url
     */
    @CacheEvict(allEntries = true)
    void updateAvatar(String username, String url);

    /**
     * 修改邮箱
     * @param username
     * @param email
     */
    @CacheEvict(allEntries = true)
    void updateEmail(String username, String email);
}
