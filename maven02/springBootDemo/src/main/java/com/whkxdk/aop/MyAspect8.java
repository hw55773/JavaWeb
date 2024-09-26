package com.whkxdk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * className:       MyAspect8
 * author:          wenhao2002
 * date:            2024/5/11 16:27
 */
@Slf4j
@Component
//@Aspect
public class MyAspect8 {

    @Before("execution(* com.whkxdk.service.DepteService.*(..))")
    public  void before(JoinPoint joinPoint){

    }
    /*
    * 在Spring中用JoinPoint抽象了连接点，用它可以获得方法执行时的相关信息，如目标类名、方法名、方法参数等
      对于 @Around 通知，获取连接点信息只能使用 ProceedingJoinPoint
      对于其他四种通知，获取连接点信息只能使用 JoinPoint ，它是 ProceedingJoinPoint 的父类型
    * */

    @Around("execution(* com.whkxdk.service.DepteService.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aroundBefore8..");
        //获取目标类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        log.info("目标类名{}",className);
        //获取目标方法签名
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("目标方法签名{}",signature);
        //获取目标方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("目标方法名{}",methodName);
        //获取目标方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("目标方法参数{}",args);
        //放行目标方法
        Object object = proceedingJoinPoint.proceed();
        //获取返回对象
        log.info("返回对象{}",object);

        log.info("aroundAfter8..");
        return object;
    }

}
