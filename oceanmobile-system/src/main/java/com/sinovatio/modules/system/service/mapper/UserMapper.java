package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.User;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName: UserMapper
 * @Description: 设置用户MapperStruct,其中uses = {RoleMapper.class} 表示共享其它映射器，解决集合如List中对象类型映射问题,componentModel = "spring" 表示使用使用spring依赖注入,unmappedTargetPolicy = ReportingPolicy.IGNORE 表示未映射的target属性将被忽略
 * @Author JinLu
 * @Date 2019/4/3 17:19
 * @Version 1.0
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
