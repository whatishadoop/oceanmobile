package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.Role;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName: RoleMapper
 * @Description: 设置菜单MapperStruct,其中uses = {PermissionMapper.class} 表示共享其它映射器，解决集合如List中对象类型映射问题,componentModel = "spring" 表示使用使用spring依赖注入,unmappedTargetPolicy = ReportingPolicy.IGNORE 表示未映射的target属性将被忽略
 * @Author JinLu
 * @Date 2019/4/3 17:19
 * @Version 1.0
 */
@Mapper(componentModel = "spring", uses = {PermissionMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

}
