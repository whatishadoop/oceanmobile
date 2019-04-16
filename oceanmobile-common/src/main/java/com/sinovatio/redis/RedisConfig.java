package com.sinovatio.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import lombok.extern.slf4j.Slf4j;
import com.sinovatio.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
* @ClassName: RedisConfig
* @Description: 设置RedisTemplate的序列化方式
* @Author JinLu
* @Date 2019/4/3 11:46
* @Version 1.0
*/
@Slf4j
@Configuration
@EnableCaching
// 同时使用 @Configuration 与 @EnableConfigurationProperties 解析yaml文件中属性，参看关与 @EnableConfigurationProperties 注解
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * @Author JinLu
     * @Description: 配置 redis 单机连接池JedisPool
     * @Param []
     * @Return redis.clients.jedis.JedisPool
     * @Date 2019/4/3 11:46
    */
    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        if (StringUtils.isNotBlank(password)) {
            return new JedisPool(jedisPoolConfig, host, port, timeout, password);
        } else {
            return new JedisPool(jedisPoolConfig, host, port,timeout);
        }
    }

    /**
     * 注意：jedis集群配置JedisCluster，它也有连接池，创建的实例都为单例
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return
     */
    //@Bean
    //public JedisCluster getJedisCluster() {
    //    String[] serverArray = redisProperties.getClusterNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
    //    Set<HostAndPort> nodes = new HashSet<>();
    //
    //    for (String ipPort : serverArray) {
    //        String[] ipPortPair = ipPort.split(":");
    //        nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
    //    }
    //
    //    return new JedisCluster(nodes,redisProperties.getCommandTimeout(),1000,1,redisProperties.getPassword() ,new GenericObjectPoolConfig());//需要密码连接的创建对象方式
    //}

    /**
     *  设置 redis 数据默认过期时间，默认1天
     *  设置@cacheable 序列化方式
     * @return
     * RedisTemplate中需要声明4种serializer，默认为“JdkSerializationRedisSerializer”：
     *
     *     1) keySerializer ：对于普通K-V操作时，key采取的序列化策略
     *     2) valueSerializer：value采取的序列化策略
     *     3) hashKeySerializer： 在hash数据结构中，hash-key的序列化策略
     *     4) hashValueSerializer：hash-value的序列化策略
     *
     *     无论如何，建议key/hashKey采用StringRedisSerializer。
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer)).entryTtl(Duration.ofDays(1)); // spring2.x设置缓存过期时间方法
        return configuration;
    }

    // 设置RedisTemplate的序列化方式为fastjson
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        // 全局开启AutoType，不建议使用
        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        // 建议使用这种方式局部支持反序列化autotype判断，小范围指定白名单, 定义哪些包下对象可以进行自动序列化操作
        // 解决漏洞，若不设置Object obj = JSON.parse(valueStr);报错，需要添加class指定类型 JSONObject.toJavaObject(obj, clazz);，设置后则Object obj = JSON.parse(valueStr)支持自动类型转换
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.modules.system.service.dto");
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.modules.test.service.dto");
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.modules.system.domain");
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.domain");
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.modules.quartz.domain");
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.modules.monitor.domain");
        ParserConfig.getGlobalInstance().addAccept("com.sinovatio.modules.security.security");
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        // template.afterPropertiesSet();
        return template;
    }

    /**
     * 自定义缓存key生成策略
     * 使用方法 @Cacheable(keyGenerator="keyGenerator")
     * @return
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                // 由于参数可能不同, hashCode肯定不一样, 缓存的key也需要不一样
                sb.append(JSON.toJSONString(obj).hashCode());
            }
            return sb.toString();
        };
    }
}