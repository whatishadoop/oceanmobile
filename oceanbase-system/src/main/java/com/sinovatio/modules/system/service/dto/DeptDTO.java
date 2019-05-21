package com.sinovatio.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.List;

/**
* @ClassName: DeptDTO
* @Description: 部门DTO对象
* @Author JinLu
* @Date 2019/4/19 15:52
* @Version 1.0
*/
@Data
public class DeptDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    @NotNull
    private Boolean enabled;

    /**
     * 上级部门
     */
    private Long pid;

    // 属性为空(' ')或者为 NULL 都不序列化,将该标记放在属性上，如果该属性为NULL则不参与序列化
    // 如果放在类上边,那对这个类的全部属性起作用,转化为json时不显示该属性
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptDTO> children;

    private Timestamp createTime;

    public String getLabel() {
        return name;
    }
}