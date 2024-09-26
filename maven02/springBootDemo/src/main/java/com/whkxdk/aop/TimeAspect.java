package com.whkxdk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * className:       TimeAspect
 * author:          wenhao2002
 * date:            2024/5/11 9:38
 */
@Slf4j
@Component
//@Aspect
@Order(1)
public class TimeAspect {

    @Around("com.whkxdk.aop.MyAspect.pt()")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //记录开始时间
      Long begin= System.currentTimeMillis();
        log.info("Around before2...");
      //运行原始方法
     Object object =proceedingJoinPoint.proceed();
        log.info("Around after2...");
        Long end=System.currentTimeMillis();

        log.info("2方法运行消耗时间 {}ms",end-begin);
        return object;
    }
}
