package com.sinovatio.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
* @ClassName: MultipartConfig
* @Description: 文件上传配置
* @Author JinLu
* @Date 2019/4/19 16:08
* @Version 1.0
*/
@Configuration
public class MultipartConfig {

    /**
     * 文件上传临时路径配置
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.home") + "/.oceanmobile/file/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }
}