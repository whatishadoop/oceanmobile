package com.sinovatio.utils;

import com.sinovatio.exception.BadRequestException;
import java.util.Optional;

/**
* @ClassName: ValidationUtil
* @Description: 验证工具
* @Author JinLu
* @Date 2019/4/3 12:44
* @Version 1.0
*/
public class ValidationUtil{

    /**
     * @Author JinLu
     * @Description: 验证空
     * @Param [optional, entity, parameter, value]
     * @Return void
     * @Date 2019/4/3 12:44
    */
    public static void isNull(Optional optional, String entity,String parameter , Object value){
        if(!optional.isPresent()){
            String msg = entity
                         + " 不存在 "
                         +"{ "+ parameter +":"+ value.toString() +" }";
            throw new BadRequestException(msg);
        }
    }

    /**
     * @Author JinLu
     * @Description: 验证是否为邮箱
     * @Param [string]
     * @Return boolean
     * @Date 2019/4/3 12:45
    */
    public static boolean isEmail(String string) {
        if (string == null){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return string.matches(regEx1);
    }
}
