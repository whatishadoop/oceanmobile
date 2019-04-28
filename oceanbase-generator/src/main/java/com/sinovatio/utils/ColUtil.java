package com.sinovatio.utils;

import org.apache.commons.configuration.*;

/**
* @ClassName: ColUtil
* @Description: sql字段转java
* @Author JinLu
* @Date 2019/4/19 14:27
* @Version 1.0
*/
public class ColUtil {

    /**
     * 转换mysql数据类型为java数据类型
     * @param type
     * @return
     */
    public static String cloToJava(String type){
        Configuration config = getConfig();
        return config.getString(type,"unknowType");
    }

    /**
     * 获取配置信息
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
