package com.zwy.autologin.filter;

import com.zwy.autologin.utls.CookieUtls;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CartFilter", urlPatterns = "/cart")
public class CartFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String token = (String) session.getAttribute("token");
        if (token == null) {
            String userName = CookieUtls.getCookie(request, "userName");
            String password = CookieUtls.getCookie(request, "password");
            if (userName != null && password != null) {
                String t = String.valueOf(System.currentTimeMillis());
//                CookieUtls.writeCookie(response, "token",t );
                session.setAttribute("token",t);
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect("/login.html");
            }

        } else {
            chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
