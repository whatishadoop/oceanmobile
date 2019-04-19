package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.domain.Dict;
import com.sinovatio.modules.system.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends EntityMapper<DictDTO, Dict> {

}