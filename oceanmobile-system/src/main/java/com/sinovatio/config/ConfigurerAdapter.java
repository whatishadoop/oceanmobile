package com.sinovatio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* @ClassName: ConfigurerAdapter
* @Description: 视图配置
* @Author JinLu
* @Date 2019/4/3 15:12
* @Version 1.0
*/
@Configuration
@EnableWebMvc
public class ConfigurerAdapter implements WebMvcConfigurer {

    /**
     * @Author JinLu
     * @Description:  服务端跨域访问配置
     * @Return
     * @Date 2019/4/3 15:44
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE");

    }

    /**
     * @Author JinLu
     * @Description:  设置视图资源路径
     * @Return
     * @Date 2019/4/3 16:07
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
    }
}
