package com.sinovatio.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
* @ClassName: ApiError
* @Description: 返回接口对象信息
* @Author JinLu
* @Date 2019/4/3 11:38
* @Version 1.0
*/
@Data
class ApiError {

    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(Integer status,String message) {
        this();
        this.status = status;
        this.message = message;
    }
}


