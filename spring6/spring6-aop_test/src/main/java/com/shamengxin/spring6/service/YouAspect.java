package com.shamengxin.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(0)
public class YouAspect {

    @Pointcut("execution(* com.shamengxin.spring6.service.OrderService.*(..))")
    public void PointCut(){}

    @After("PointCut()")
    public void afterAdvice(){
        System.out.println("YouAspect最终通知");
    }

    @AfterThrowing("PointCut()")
    public void afterThrowingAdvice(){
        System.out.println("YouAspect异常通知");
    }


    @Around("PointCut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("YouAspect环绕通知开始");
        proceedingJoinPoint.proceed();
        System.out.println("YouAspect环绕通知结束");
    }

    @AfterReturning("PointCut()")
    public void afterReturnAdvice(){
        System.out.println("YouAspect后置通知");
    }

    @Before("PointCut()")
    public void beforeAdvice(){
        System.out.println("YouAspect前置通知");
    }

}
