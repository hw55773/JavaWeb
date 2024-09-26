package com.whkxdk.filter;

import com.alibaba.fastjson.JSONObject;
import com.whkxdk.pojo.Result;
import com.whkxdk.utils.JwtUtiles;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * className:       LoginController
 * author:          wenhao2002
 * date:            2024/5/9 20:12
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginController implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转为HttpServlet
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        //判断是否是login请求
       String url=req.getRequestURL().toString();
       log.info("请求url {}",url);
       if(url.contains("login")){
           log.info("登录操作放行");
           //放行
           filterChain.doFilter(servletRequest,servletResponse);
           return;
       }
       //获取请求头中的token令牌
        String jwt=req.getHeader("token");
       //校验令牌是否存在
       if(!StringUtils.hasLength(jwt)){
           log.info("请求token为空");
          Result err= Result.error("NO_LOGIN");
          String nologin= JSONObject.toJSONString(err);
           resp.getWriter().write(nologin);
           return;
       }
       //校验令牌是否合法
        Claims claims= JwtUtiles.jwtValidate(jwt);
       if(claims==null){
           Result err= Result.error("NO_LOGIN");
           String nologin= JSONObject.toJSONString(err);
           resp.getWriter().write(nologin);
           return;
       }
       //放行
        log.info("令牌合法");
       filterChain.doFilter(servletRequest,servletResponse);



    }
}
