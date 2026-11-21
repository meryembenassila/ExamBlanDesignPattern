package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component 
@EnableAspectJAutoProxy

public class LogAspect {
    Logger log= Logger.getLogger(LogAspect.class.getName());


    @Around("@annotation(org.example.aspects.Log)")
    public  Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        log.info("From Logging Aspects .... Before " + proceedingJoinPoint.getSignature());
        Object o = proceedingJoinPoint.proceed();
        log.info("From Logging Aspects .... After " +  proceedingJoinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        log.info("Duration " + (t2-t1));
        return o;

    }
}

