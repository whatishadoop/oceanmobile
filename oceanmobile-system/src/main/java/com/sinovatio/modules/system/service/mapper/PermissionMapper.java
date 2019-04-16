package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.Permission;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName: PermissionMapper
 * @Description: 设置权限的MapperStruct
 * @Author JinLu
 * @Date 2019/4/3 17:19
 * @Version 1.0
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
