package com.whkxdk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * className:       MyAspect
 * author:          wenhao2002
 * date:            2024/5/11 10:34
 */
@Slf4j
@Component
//@Aspect//不同切面执行顺序，按照类名排序，先入后出
@Order//注解默认为最大值，当写入的数字越小，切面类越先执行。
public class MyAspect {
    /*
    * @Around:    环绕通知，此注解标注的通知方法在目标方法前、后都被执行
      @Before:   前置通知，此注解标注的通知方法在目标方法前被执行
      @After:    后置通知，此注解标注的通知方法在目标方法后被执行，无论是否有异常都会执行
      @AfterReturning: 返回后通知，此注解标注的通知方法在目标方法后被执行，有异常不会执行
      @AfterThrowing : 异常后通知，此注解标注的通知方法发生异常后执行
      @PointCut: 该注解的作用是将公共的切点表达式抽取出来，需要用到时引用该切点表达式即可
      *
    * */
    @Pointcut("execution(* com.whkxdk.service.impl.DepteServiceImpl.*(..))")
    public void pt() {
    }

    @Before("pt()")
    public void before() {
        log.info("Before1...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //记录开始时间
        Long begin = System.currentTimeMillis();
        log.info("Around before1...");
        //运行原始方法
        Object object = proceedingJoinPoint.proceed();
        log.info("Around after1...");
        Long end = System.currentTimeMillis();

        log.info("1方法运行消耗时间 {}ms", end - begin);
        return object;

    }

    @After("pt()")
    public void after() {
        log.info("After1...");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("AfterReturning1...");
    }

    @AfterThrowing("pt()")
    public void afterThrow() {
        log.info("AfterThrowing1...");
    }
}
