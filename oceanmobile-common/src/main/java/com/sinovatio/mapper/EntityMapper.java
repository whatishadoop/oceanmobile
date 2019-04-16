package com.sinovatio.mapper;

import java.util.List;

/**
* @ClassName: EntityMapper
* @Description: DTO对象与实体mapstruct映射
* @Author JinLu
* @Date 2019/4/3 11:43
* @Version 1.0
*/
public interface EntityMapper<D, E> {

    /**
     * @Author JinLu
     * @Description: DTO转Entity
     * @Param [dto]
     * @Return E
     * @Date 2019/4/3 11:44
    */
    E toEntity(D dto);

   /**
    * @Author JinLu
    * @Description:  Entity转DTO
    * @Param [entity]
    * @Return D
    * @Date 2019/4/3 11:44
   */
    D toDto(E entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList
     * @return
     */
    List <E> toEntity(List<D> dtoList);

    /**
     * @Author JinLu
     * @Description: Entity集合转DTO集合
     * @Param [entityList]
     * @Return java.util.List<D>
     * @Date 2019/4/3 11:44
    */
    List <D> toDto(List<E> entityList);
}
