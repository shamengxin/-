package com.shamengxin.spring6.bank;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class TransactionAspect {

    @Around("execution(* com.shamengxin.spring6.bank..*(..))")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        try{
            System.out.println("开启事务");

            proceedingJoinPoint.proceed();

            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

}
