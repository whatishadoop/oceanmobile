package com.sinovatio.modules.monitor.rest;

import com.sinovatio.aop.limit.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @ClassName: LimitController
* @Description: 接口限流测试类
* @Author JinLu
* @Date 2019/4/3 16:13
* @Version 1.0
*/
@RestController
@RequestMapping("api")
public class LimitController {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    /**
     * @Author JinLu
     * @Description: 测试限流注解，下面配置说明该接口 60秒内最多只能访问 10次，保存到redis的键名为 limit_test，
     * @Return
     * @Date 2019/4/3 16:14
    */
    @Limit(key = "test", period = 60, count = 10, name = "testLimit", prefix = "limit")
    @GetMapping("/limit")
    public int testLimit() {
        return ATOMIC_INTEGER.incrementAndGet();
    }
}
