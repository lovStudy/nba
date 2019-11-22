package com.cn.nba.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyTestProperties.class)
public class EnableAutoTest {


    @Bean
    public MyTest myTest(MyTestProperties myTestProperties){
        MyTest myTest = new MyTest();
        myTest.setSpring(myTestProperties.getSpring());
        return  myTest;
    }

}
