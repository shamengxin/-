package com.shamengxin.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Aspect
@Service
@Order(1)
public class MyAspect {

    @After(("execution(* com.shamengxin.spring6.service.OrderService.*(..))"))
    public void afterAdvice(){
        System.out.println("最终通知");
    }

    @AfterThrowing("execution(* com.shamengxin.spring6.service.OrderService.*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }


    @Around("execution(* com.shamengxin.spring6.service.OrderService.*(..))")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
    }

    @AfterReturning("execution(* com.shamengxin.spring6.service.OrderService.*(..))")
    public void afterReturnAdvice(){
        System.out.println("后置通知");
    }

    @Before("execution(* com.shamengxin.spring6.service.OrderService.*(..))")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

}
