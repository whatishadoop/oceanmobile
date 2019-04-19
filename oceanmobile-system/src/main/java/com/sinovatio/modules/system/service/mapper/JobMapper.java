package com.sinovatio.modules.system.service.mapper;

import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.modules.system.domain.Job;
import com.sinovatio.modules.system.service.dto.JobDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends EntityMapper<JobDTO, Job> {

}