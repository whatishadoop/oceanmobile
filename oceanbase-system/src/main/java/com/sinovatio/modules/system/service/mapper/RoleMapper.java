package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.Role;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @ClassName: RoleMapper
* @Description: 角色映射
* @Author JinLu
* @Date 2019/4/19 15:56
* @Version 1.0
*/
@Mapper(componentModel = "spring", uses = {PermissionMapper.class, MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

}
