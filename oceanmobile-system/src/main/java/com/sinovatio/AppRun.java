package com.sinovatio;

import com.sinovatio.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
* @ClassName: AppRun
* @Description: 移动端平台启动主函数
* @Author JinLu
* @Date 2019/4/3 17:27
* @Version 1.0
*/
@SpringBootApplication
@EnableTransactionManagement
@EnableWebSocketMessageBroker  // 开启websocket
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
