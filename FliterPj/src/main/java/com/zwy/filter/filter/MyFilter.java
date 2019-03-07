package com.zwy.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",
        urlPatterns = "/product/*",
        dispatcherTypes = {DispatcherType.REQUEST})
//@Component //过滤所有路径，不能跟WebFilter同时使用
//@Configuration //过滤所有路径
public class MyFilter implements Filter {
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    //用来做过滤操作，拦截请求还是放行请求，都在这个方法里面操作
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter...");

        HttpServletResponse hsr = (HttpServletResponse) response;
        hsr.sendRedirect("/user/login.html");
        //放行
//        chain.doFilter(request, response);

    }

    //销毁
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
