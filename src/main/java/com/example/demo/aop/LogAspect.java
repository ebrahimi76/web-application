package com.example.demo.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Log LOGGER= LogFactory.getLog("METHOD_LOGGER");

    @Pointcut("execution(public * com.example.demo.service.*.*(..))")
    public void allMethod(){
    }

    @Around("allMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info(String.format(
                "Method %s is going to call from class %s",
                joinPoint.getSignature().toString(),
                joinPoint.getThis().getClass().getSimpleName()
        ));

        Object returnObject = joinPoint.proceed(joinPoint.getArgs());

        LOGGER.info(String.format(
                "Method %s has called from class %s with return value type %s",
                joinPoint.getSignature().toString(),
                joinPoint.getThis().getClass().getSimpleName(),
                returnObject.getClass().getName()
        ));
        return returnObject;
    }
}