package com.xj.family.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        RedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer();// or  Jackson2JsonRedisSerializer
        // StringRedisSerializer cause 500 err:
        //     java.util.ArrayList cannot be cast to java.lang.String
        template.setConnectionFactory(factory);
        // ref: https://blog.csdn.net/huangpeigui/article/details/89671690
        //     解决redis redistemplate KEY为字符串是多双引号的问题
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(redisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(redisSerializer);

        return template;
    }
}
