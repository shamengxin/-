package com.shamengxin.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.shamengxin.spring6.biz..save*(..))")
    public void savePoint(){}

    @Pointcut("execution(* com.shamengxin.spring6.biz..delete*(..))")
    public void deletePoint(){}

    @Pointcut("execution(* com.shamengxin.spring6.biz..modify*(..))")
    public void modifyPoint(){}


    @Before("savePoint() || deletePoint() || modifyPoint()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("xxx操作员正在操作"+joinPoint.getSignature().getName()+"方法");
    }

}
