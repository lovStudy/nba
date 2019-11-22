package com.cn.nba.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Mytest1 {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void saveMes(){
        System.out.println("程序启动自动初始化信息---");
        Map<String,Object>  map = new HashMap<>();
        map.put("G71326",4);
        map.put("G71326",14);

    }
}
