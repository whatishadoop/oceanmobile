package com.sinovatio.service.mapper;

import com.sinovatio.domain.Application;
import com.sinovatio.mapper.EntityMapper;
import com.sinovatio.service.dto.ApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName: ApplicationMapper
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 11:26
 * @Version 1.0
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApplicationMapper extends EntityMapper<ApplicationDTO, Application> {
}
