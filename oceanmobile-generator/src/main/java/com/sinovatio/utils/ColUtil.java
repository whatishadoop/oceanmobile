package com.sinovatio.utils;

import org.apache.commons.configuration.*;

/**
* @ClassName: ColUtil
* @Description: sql字段转java
* @Author JinLu
* @Date 2019/4/3 14:05
* @Version 1.0
*/
public class ColUtil {

    /**
     * @Author JinLu
     * @Description: 转换mysql数据类型为java数据类型
     * @Param 数据类型
     * @Return java.lang.String
     * @Date 2019/4/3 14:05
    */
    public static String cloToJava(String type){
        Configuration config = getConfig();
        return config.getString(type,"unknowType");
    }

    /**
     * @Author JinLu
     * @Description: 获取配置信息
     * @Param []
     * @Return org.apache.commons.configuration.PropertiesConfiguration
     * @Date 2019/4/3 14:05
    */
    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties" );
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
