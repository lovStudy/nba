package com.cn.nba;

import com.cn.nba.config.TestConfig;
import com.cn.nba.exception.ExceptionHandlerController;
import com.cn.nba.pay.MyWxPayConfig;
import com.cn.nba.proxy.TestProxy;
import com.cn.nba.queque.RabbitmqConfig;
import com.cn.nba.queque.SendQueue;
import com.cn.nba.ribbon.RibbonServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan(basePackages = {"com.cn.nba.controller","com.cn.nba.service","com.cn.nba.dao"})
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients
//@EnableScheduling
@EnableAsync
@EnableTransactionManagement
@Import(value = {MyWxPayConfig.class,TestProxy.class,RibbonServer.class,SendQueue.class,RabbitmqConfig.class,ExceptionHandlerController.class})
public class NbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbaApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
