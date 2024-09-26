package com.whkxdk.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * className:       DemoFilter
 * author:          wenhao2002
 * date:            2024/5/9 18:32
 */
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override//初始化方法，只执行一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化了");
        Filter.super.init(filterConfig);
    }

    @Override//拦截响应请求,多次调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo处理数据ing");
        System.out.println("Demo放行前逻辑...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Demo放行后逻辑...");//不会重头执行
    }

    @Override//销毁方法,只执行一次
    public void destroy() {
        System.out.println("销毁了");
        Filter.super.destroy();
    }
}
