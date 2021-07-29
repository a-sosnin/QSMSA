package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(com.example.restservice.GreetingController)")
    public void processing() {
        
    }

    @Before("processing()")
    public void logInput(JoinPoint joinPoint) {
        Object[] inputArguments = joinPoint.getArgs();
        logger.info("Input arguments " + Arrays.toString(inputArguments));
    }

    @AfterReturning(pointcut = "processing()", returning = "result")
    public void logOutput(JoinPoint joinPoint, Object result) {
        logger.info("Output is " + result);
    }

    @Around(value = "execution(public com.example.restservice.GreetingController greeting(..))")
    public Object logArguments(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Input is");
        Object[] inputArguments = joinPoint.getArgs();
        for(Object obj : inputArguments) {
            logger.info("argument = " + obj);
        }
        Object result = joinPoint.proceed();
        logger.info("Output is " + result);
        return result;
    }
}
