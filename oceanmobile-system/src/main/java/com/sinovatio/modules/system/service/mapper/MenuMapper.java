package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.modules.system.domain.Menu;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @ClassName: MenuMapper
* @Description: 菜单映射
* @Author JinLu
* @Date 2019/4/19 15:56
* @Version 1.0
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
