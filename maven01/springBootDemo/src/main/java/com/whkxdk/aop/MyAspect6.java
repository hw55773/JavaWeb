package com.whkxdk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * className:       MyAspect6
 * author:          wenhao2002
 * date:            2024/5/11 15:25
 */
@Component
@Slf4j
//@Aspect
public class MyAspect6 {

    /*
    * execution 主要根据方法的返回值、包名、类名、方法名、方法参数等信息来匹
      execution(访问修饰符? 返回值 包名.类名.?方法名(方法参数)throws 异常)
      其中带?的表示可以省略的部分
      访问修饰符:可省略 (比如: public、protected)
      包名.类名: 可省略
      throws 异常:可省略 (注意是方法上声明抛出的异常，不是实际抛出的异常)
    * */
    /*
    * 可以使用通配符描述切入点
      '*' :单个独立的任意符号，可以通配任意返回值、包名、类名、方法名、任意类型的一个参数，也可以通配包、类、方法名的一部分
         execution(* com.*.service.*.udate*(*))
     '..' :多个连续的任意符号，可以通配任意层级的包，或任意类型、任意个数的参数
         execution(* com.itheima..DeptService.*( ..))
    * */
    /*
    * 根据业务需要，可以使用 且 (&&)、或(||)、非(!) 来组合比较复杂的切入点表达式
    * */
    @Pointcut("execution(public com.whkxdk.pojo.Depte com.whkxdk.service.DepteService.getDepteById(java.lang.Integer) ) ||execution(public * com.whkxdk.service.DepteService.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before6..");
    }
}
