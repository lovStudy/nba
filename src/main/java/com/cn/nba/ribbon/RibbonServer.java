package com.cn.nba.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServer {

    @Autowired
    private RestTemplate restTemplate;


    public String getStringTest(String str, String str1) {
        return restTemplate.getForObject("http://football/football/getStringTest?str=" + str + "&str1=" + str1, String.class);
    }


}
