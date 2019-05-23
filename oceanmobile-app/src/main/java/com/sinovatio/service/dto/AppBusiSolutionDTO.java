package com.sinovatio.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
* @author admin
* @date 2019-05-21
*/
@Data
public class AppBusiSolutionDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * create_time
     */
    private Timestamp createTime;

    /**
     * enabled
     */
    private Boolean enabled;

    /**
     * name
     */
    private String name;

    /**
     * pid
     */
    private Long pid;

    public String getLabel(){
        return name;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AppBusiSolutionDTO> children;
}