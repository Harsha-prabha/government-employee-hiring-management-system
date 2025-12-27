package com.examly.springapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.examly.springapp.controller.*.*(..))")
    public void logBeforeController() {
        System.out.println("Controller method invoked");
    }
}
