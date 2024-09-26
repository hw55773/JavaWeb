package com.whkxdk.aop;

import com.alibaba.fastjson.JSONObject;
import com.whkxdk.mapper.LogMapper;
import com.whkxdk.pojo.DepteLog;
import com.whkxdk.utils.JwtUtiles;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * className:       LogAspect
 * author:          wenhao2002
 * date:            2024/5/11 18:54
 */
@Aspect
@Data
@Slf4j
@Component
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogMapper logMapper;

    @Around("@annotation(com.whkxdk.anonation.Log)")
    public Object Log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取操作人id
        String jwt = request.getHeader("token");
        Claims claims = JwtUtiles.jwtValidate(jwt);
        Integer operateUser = (Integer) claims.get("id");
        log.info("操作人id, {}",operateUser);
        //获取操作时间
        LocalDateTime dateTime=LocalDateTime.now();
        //获取类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取操作方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //操作方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        String methodPararms = Arrays.toString(args);
        //获取操作方法返回值
        Long begin=System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        Long end=System.currentTimeMillis();
        String returnValue = JSONObject.toJSONString(object);
        //获取操作耗时
        Long cost=end-begin;
        DepteLog depteLog=new DepteLog(null,operateUser, dateTime,className,methodName,methodPararms,returnValue,cost);
        logMapper.insert(depteLog);
        return object;
    }
}
