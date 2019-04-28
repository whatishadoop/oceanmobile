package com.sinovatio.modules.monitor.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
* @ClassName: RedisVo
* @Description: RedisVo 视图对象
* @Author JinLu
* @Date 2019/4/19 14:33
* @Version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisVo implements Serializable {

    @NotBlank
    private String key;

    @NotBlank
    private String value;
}
