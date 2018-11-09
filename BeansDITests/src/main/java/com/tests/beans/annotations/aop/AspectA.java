package com.tests.beans.annotations.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectA {

    @After("execution(* CompoA.meth1())")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("inside advice, after the method call");
    }

    @Around("execution(* CompoA.meth1())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("inside advice, around the method call, before");
        Object res = joinPoint.proceed();
        System.out.println("inside advice, around the method call, after");
        return res;
    }

}
