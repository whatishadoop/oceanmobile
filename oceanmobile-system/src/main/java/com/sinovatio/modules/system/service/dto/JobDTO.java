package com.sinovatio.modules.system.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author jie
* @date 2019-03-29
*/
@Data
@NoArgsConstructor
public class JobDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    private Long sort;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private Boolean enabled;

    private DeptDTO dept;

    /**
     * 创建日期
     */
    private Timestamp createTime;

    public JobDTO(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}