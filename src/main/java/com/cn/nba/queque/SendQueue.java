package com.cn.nba.queque;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SendQueue {


    @Bean
    public Queue myTestQueue(){
        return new Queue("myTestQueue",true);
    }


    @Bean
    public DirectExchange myExchange(){
        return new DirectExchange("exchange");
    }


    @Bean
    public Binding binding(Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("rount");
    }




}
