package com.example.springbootintegrateredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redisTest")
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/testString")
    @ResponseBody
    public String testString() {
        redisTemplate.opsForValue().set("name", "zhicheng");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
        return name;
    }
}
