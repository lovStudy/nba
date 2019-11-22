package com.cn.nba.proxy;

import com.cn.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Component
public class TestProxy implements InvocationHandler {

    @Autowired
    private TeamService teamService;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy...before");
        Object result = method.invoke(teamService, args);
        System.out.println("proxy...after");
        return result;
    }


}
