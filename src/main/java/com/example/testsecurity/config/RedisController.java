package com.example.testsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuzhenwei
 * @date: 2020/11/5
 */

@RestController
public class RedisController {
    @Autowired
    private org.springframework.data.redis.core.StringRedisTemplate redisTemplate ;

    @GetMapping("/add")
    public String add(String key,String value){
        System.out.println(key+":"+value);
        redisTemplate.opsForValue().set(key,value);
        return "ok";
    }
}
