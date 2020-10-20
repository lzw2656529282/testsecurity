package com.example.testsecurity.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: liuzhenwei
 * @date: 2020/10/19
 */
@Configuration
@Resource(name = "classpath:application.xml")
public class RedisConfig  {
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        String redisUrl = String.format("redis://%s:%s",redisProperties.getHost()+"",redisProperties.getPort()+"");
        config.useSingleServer().setAddress(redisUrl);
        return Redisson.create(config);
    }
}
