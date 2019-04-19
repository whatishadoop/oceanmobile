package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.domain.Dept;
import com.sinovatio.modules.system.service.dto.DeptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends EntityMapper<DeptDTO, Dept> {

}