package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.domain.DictDetail;
import com.sinovatio.modules.system.service.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @ClassName: DictDetailMapper
* @Description: 字典详情映射
* @Author JinLu
* @Date 2019/4/19 15:56
* @Version 1.0
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}