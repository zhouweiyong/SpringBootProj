package com.zwy.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class MyFilter2 implements Filter {
    public void destroy() {
        System.out.println("MyFilter2 destroy...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("MyFilter2 doFilter...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("MyFilter2 init...");
    }

}
