package com.sinovatio.modules.system.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @ClassName: DictDetailDTO
* @Description: 字典详情DTO对象
* @Author JinLu
* @Date 2019/4/19 15:52
* @Version 1.0
*/
@Data
public class DictDetailDTO implements Serializable {

    private Long id;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典值
     */
    private String value;

    /**
     * 排序
     */
    private String sort;

    /**
     * 字典id
     */
    private String dictName;
}