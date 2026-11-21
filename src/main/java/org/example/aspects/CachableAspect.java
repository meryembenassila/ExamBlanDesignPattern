package org.example.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.Transaction;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
@EnableAspectJAutoProxy

public class CachableAspect {

    Transaction transactioncache = null;
    @Around("@annotation(org.example.aspects.Cachable)")
    public  Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

     if(transactioncache==null){
         Object object = proceedingJoinPoint.proceed();
         transactioncache = (Transaction) object;
     }
     return  transactioncache;
}

}