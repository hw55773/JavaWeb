package com.whkxdk.config;

import com.whkxdk.intercepter.LoginCheckIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className:       WebConfig
 * author:          wenhao2002
 * date:            2024/5/9 21:22
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckIntercepter loginCheckIntercepter;

    @Override// "/** 表示任意路径; /depte/* 表示/depted的下一级路径 ;/depte/** 表示下的任意路径"
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckIntercepter)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
