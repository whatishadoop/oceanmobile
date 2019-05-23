package com.sinovatio.modules.monitor.config;

import com.sinovatio.modules.monitor.domain.LogMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @ClassName: WebSocketConfig
* @Description: 配置WebSocket消息代理端点，即stomp服务端
* @Author JinLu
* @Date 2019/4/19 14:33
* @Version 1.0
*/
@Slf4j
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println(executorService);
        // 注册STOMP协议的节点，并指定映射的URL服务端点，来接收客户端的连接，同时指定使用SockJS协议
        System.out.println("==============websocket注册成功=============");
        registry.addEndpoint("/websocket")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    // WebSocketStompConfig还通过重载configureMessageBroker（）方法配置了一个简单的消息代理。这个方法是可选的，如果不重载它的话，将会自动配置一个简单的内存消息代理，用它来处理以“/topic”为前缀的消息
    //@Override
    //public void configureMessageBroker(MessageBrokerRegistry registry)
    //{
    //
    //    //表明在topic、queue、users这三个域上可以向客户端发消息。
    //    registry.enableSimpleBroker("/topic","/queue","/users");
    //    //客户端向服务端发起请求时，需要以/app为前缀。
    //    registry.setApplicationDestinationPrefixes("/app");
    //    //给指定用户发送一对一的消息前缀是/users/。
    //    registry.setUserDestinationPrefix("/users/");
    //}


    /**
     * 推送日志到/topic/pullLogger
     */
    @PostConstruct
    public void pushLogger(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 若队列中没有实例则阻塞
                        LogMessage log = LoggerQueue.getInstance().poll();
                        System.out.println(log.toString());
                        if(log!=null){
                            // 格式化异常堆栈信息
                            if("ERROR".equals(log.getLevel()) && "com.sinovatio.common.exception.handler.GlobalExceptionHandler".equals(log.getClassName())){
                                log.setBody("<pre>"+log.getBody()+"</pre>");
                            }
                            if(log.getClassName().equals("jdbc.resultsettable")){
                                log.setBody("<br><pre>"+log.getBody()+"</pre>");
                            }
                            if(messagingTemplate!=null){
// Spring的SimpMessagingTemplate能够在应用的任何地方发送消息，甚至不必以首先接收一条消息作为前提。//使用SimpMessagingTemplate的最简单方式是将它（或者其接口SimpMessageSendingOperations）自动装配到所需的对象中，默认内存队列为topic
                                messagingTemplate.convertAndSend("/topic/logMsg",log);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        executorService.execute(runnable);
    }
}