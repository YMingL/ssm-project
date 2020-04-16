package com.yang.shop.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig(); //获取默认cacheConfig
        configuration = configuration.entryTtl(Duration.ofDays(30))
                .disableCachingNullValues()//设置过期时间及不缓存空值
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//        设置缓存空间
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("userInfo");
        cacheNames.add("userGold");

//        对每个缓存空间应用配置
        Map<String,RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap.put("userInfo",configuration);
        cacheConfigurationMap.put("userGold",configuration);

        RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory) //初始化一个cacheManager
                .initialCacheNames(cacheNames)  //设置初始化缓存名
                .withInitialCacheConfigurations(cacheConfigurationMap)
                .build();

        return cacheManager;
    }
}
