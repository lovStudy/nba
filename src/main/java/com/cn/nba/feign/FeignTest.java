package com.cn.nba.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "football")
public interface FeignTest {

    @RequestMapping(value = "/football/getStringTest", method = RequestMethod.GET)
    String getTest(@RequestParam("str") String str, @RequestParam("str1") String str1);
}
