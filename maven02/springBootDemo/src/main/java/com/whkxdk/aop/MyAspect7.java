package com.whkxdk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * className:       MyAspect7
 * author:          wenhao2002
 * date:            2024/5/11 16:02
 */
@Component
//@Aspect
@Slf4j
public class MyAspect7 {

    @Before("@annotation(com.whkxdk.anonation.Myanonation)")//通过@annotation减少臃肿的代码，需要特定注解标识
    public void before(){
        log.info("before7..");
    }
}
