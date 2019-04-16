package com.sinovatio.modules.monitor.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: RedisVo
* @Description: 缓存VO
* @Author JinLu
* @Date 2019/4/3 16:10
* @Version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisVo {

    @NotBlank
    private String key;

    @NotBlank
    private String value;
}
