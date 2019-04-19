package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.domain.DictDetail;
import com.sinovatio.modules.system.service.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}