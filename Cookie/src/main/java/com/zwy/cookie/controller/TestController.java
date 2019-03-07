package com.zwy.cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    //设置cookie
    @RequestMapping("/test")
    public String test(HttpServletResponse response) {

        Cookie cookie = new Cookie("name", "tom");
        cookie.setDomain("zwy.com");
        response.addCookie(cookie);
        response.addCookie(new Cookie("age", "36"));
        return "index.html";

    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(HttpServletRequest request){
        StringBuffer buffer  = new StringBuffer();
        Cookie[] cookies = request.getCookies();
        if (cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                buffer.append(name).append(":").append(value).append("\n");
            }
        }
        return buffer.toString();
    }
}
