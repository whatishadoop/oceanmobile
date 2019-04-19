package com.sinovatio.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @ClassName: DictDTO
* @Description: 数据字典DTO
* @Author JinLu
* @Date 2019/4/19 15:52
* @Version 1.0
*/
@Data
public class DictDTO implements Serializable {

    private Long id;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 描述
     */
    private String remark;
}