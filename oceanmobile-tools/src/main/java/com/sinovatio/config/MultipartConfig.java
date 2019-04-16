package com.sinovatio.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
* @ClassName: MultipartConfig
* @Description: 文件上传配置服务
* @Author JinLu
* @Date 2019/4/3 17:27
* @Version 1.0
*/
@Configuration
public class MultipartConfig {

    /**
     * @Author JinLu
     * @Description: 文件上传临时路径
     * @Return javax.servlet.MultipartConfigElement
     * @Date 2019/4/3 17:28
    */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.dir") + "target/file/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }
}