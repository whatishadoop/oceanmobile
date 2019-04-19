package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.User;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @ClassName: UserMapper
* @Description: 用户映射
* @Author JinLu
* @Date 2019/4/19 15:57
* @Version 1.0
*/
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
