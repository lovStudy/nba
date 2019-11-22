package com.cn.nba.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.nba.config.MyTest;
import com.cn.nba.entity.Team;
import com.cn.nba.queque.RabbitmqConfig;
import com.cn.nba.ribbon.RibbonServer;
import com.cn.nba.service.TeamService;
import com.cn.nba.util.HttpUtil;
import com.cn.nba.util.PinyinUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/")
@RefreshScope
public class TestController {


    @Autowired
    private TeamService teamService;
    @Autowired
    private RibbonServer ribbonServer;
    @Autowired
    private MyTest mytest;
    @Autowired
    private RabbitmqConfig rabbitmqConfig;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${nbatest}")
    private String test;

    @GetMapping("/test2")
    @ResponseBody
    public String test(@RequestParam(value = "name",required = false)String name) {
   //     System.out.println(applicationContext.getBean("teamServiceImpl"));
     //   System.out.println(Runtime.getRuntime().availableProcessors());
        String s = ribbonServer.getStringTest("asdf", "ssss");
        return "";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public void test1() {
        String t="7adfb6b1b3b5990cc39ad41be0934d53e06fd880809b06e9b45d10a6342d0d6884993171d07f1f242a7a3ce14cda1b1d26ab5b56441722bef12ce303b2c74a55f6ee96dd97b71801a624ce63df2958b639c8723725fb35b6a207e88ed29366dbcfb1369d1981491d910970757e2ff98d7c588cf8a6174e42e64b1761187185547a1488f8962349c0078d11374249780eede7442230695018eba61d066508231f3034e0cffce634358d794c05ea5c8aed24dd0de8f2919866fc69a3f699c649108e22eba4bdab6773547b8cb035da880910bb0ef69ac73b83976c996988c3a1f815107f1e52d6fab3d86a406ecefce43645677d4fb06fdeb06c3d8a17a53e3480696dd26318ff4df70d549bf08298237606b9c0c4d252f7ddbec283d6b448a3002ab33f2e23d994c9de6f763bc10f6a1c9b709077276d0d68e83bbfdd789a77aea51db77864d9eed81814436c8f60213d7246033fa0b0fd0fd8c31555aefceb92cf4e0fc197c54ae0351947c4e76aee154733f6fd82fac5b42d52dc5af0a8573164fe1f6d4e9aa5c668a293f8ad2613d1";
        String xs_app = "asr_api";
        Map<String,Object> map = new HashMap<>();
        map.put("t",t);
        map.put("xs_app",xs_app);
        HttpUtil.httpPost("https://ascott-uat.crmxs.com",map);


    }


    @RequestMapping(value = "/test3")
    @ResponseBody
    public void test3(){

        System.out.println(test);

    }

    @RequestMapping(value = "/test4",method = RequestMethod.POST)
    @ResponseBody
    public void test4(@RequestBody @Valid Team team){




    }


    @GetMapping(value = "/test5")
    @ResponseBody
    public void test5(){
        System.out.println("redis--------");
        Map<String,Object> map = new HashMap<>();
        map.put("xx",123);
        redisTemplate.opsForHash().put("key","name","jack");
        redisTemplate.opsForHash().put("key","name1","jack1");
        redisTemplate.opsForHash().putIfAbsent("key","name2","jack2");
        redisTemplate.opsForHash().putAll("key1",map);

    }



}
