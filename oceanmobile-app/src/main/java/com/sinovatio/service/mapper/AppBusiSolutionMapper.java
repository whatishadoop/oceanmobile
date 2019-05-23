package com.sinovatio.service.mapper;

import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.domain.AppBusiSolution;
import com.sinovatio.service.dto.AppBusiSolutionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author admin
* @date 2019-05-21
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppBusiSolutionMapper extends EntityMapper<AppBusiSolutionDTO, AppBusiSolution> {

}