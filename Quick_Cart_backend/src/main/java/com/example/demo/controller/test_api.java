package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;


@RestController
@RequestMapping("/api/redis")
public class test_api {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @GetMapping("/test")
    public String testRedisConnection() {
        try {
            redisTemplate.opsForValue().set("testKey", "testValue");
            String value = redisTemplate.opsForValue().get("testKey");
            return value != null ? "Redis connected successfully. Value: " + value : "Failed to connect to Redis.";
        } catch (Exception e) {
            return "Error connecting to Redis: " + e.getMessage();
        }
    }
}
