package com.springboot.preparation.aop;


import jakarta.servlet.ServletOutputStream;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    @Around("execution(* com.springboot.preparation.controller.*.*(..))")
    public Object logAroundControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();

        System.out.println("Started at: "+start);
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis()-start;

        System.out.println(joinPoint.getSignature()+" executed in "+executionTime +" ms");
        return proceed;
    }
}
