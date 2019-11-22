package com.cn.nba.aop;


import com.cn.nba.entity.Team;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Component
@Aspect
public class AspectAop {

    @Pointcut("execution(* com.cn.nba.service..*.*(..))")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void before() {
        System.out.println("进入方法前");

    }

    @After("pointCut()")
    public void after() {
        System.out.println("方法结束");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("AOP AfterReturning Advice:" + method);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("AOP AfterThrowing Advice..." + error);

    }

    @Around("pointCut()")
    public List<Team> around(ProceedingJoinPoint pjp) {
        System.out.println("AOP Aronud before...");
        List<Team> list = null;
        try {
            list = (List<Team>) pjp.proceed();
            System.out.println(list.get(0).getName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Aronud after...");
        return list;
    }


}
