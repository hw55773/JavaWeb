package com.whkxdk.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.whkxdk.pojo.Result;
import com.whkxdk.utils.JwtUtiles;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * className:       LoginCheckIntercepter
 * author:          wenhao2002
 * date:            2024/5/9 21:17
 */
@Slf4j
@Component
public class LoginCheckIntercepter implements HandlerInterceptor {
    @Override//资源方法执行前执行，放回；执行：true,放回：false
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        //获取请求头中的token令牌
        String jwt=request.getHeader("token");
        //校验令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("请求token为空");
            Result err= Result.error("NO_LOGIN");
            String nologin= JSONObject.toJSONString(err);
            response.getWriter().write(nologin);
            return false;
        }
        //校验令牌是否合法
        Claims claims= JwtUtiles.jwtValidate(jwt);
        if(claims==null){
            log.info("令牌非法");
            Result err= Result.error("NO_LOGIN");
            String nologin= JSONObject.toJSONString(err);
            response.getWriter().write(nologin);
            return false;
        }
        //放行
        log.info("令牌合法");
        return true;
    }

    @Override//资源方法执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override//视图渲染完毕后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
