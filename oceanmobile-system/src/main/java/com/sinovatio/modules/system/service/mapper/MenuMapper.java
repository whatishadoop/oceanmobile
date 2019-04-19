package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.Menu;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
