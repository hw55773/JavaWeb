package com.whkxdk.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * className:       AbcFilter
 * author:          wenhao2002
 * date:            2024/5/9 19:24
 */
@WebFilter(urlPatterns = "/*")//过滤器链,优先级按类名排序
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc处理数据ing");
        System.out.println("Abc放行前逻辑...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Abc放行后逻辑...");//不会重头执行
    }
}
