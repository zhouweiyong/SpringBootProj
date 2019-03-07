package com.zwy.autologin.controller;

import com.zwy.autologin.bean.UserBean;
import com.zwy.autologin.utls.CookieUtls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @PostMapping("/loginHandler")
    public ModelAndView loginHandler(UserBean userBean, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        if ("admin".equals(userBean.getUserName()) && "123456".equals(userBean.getPassword())) {
            if (userBean.getIsAuto()!=null){
                CookieUtls.writeCookie(response, "userName", userBean.getUserName());
                CookieUtls.writeCookie(response, "password", userBean.getPassword());
            }
            request.getSession().setAttribute("token", String.valueOf(System.currentTimeMillis()));
            mav.addObject("userName", userBean.getUserName());
            mav.setViewName("success");
        } else {
            mav.setViewName("fail");
        }


        return mav;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().removeAttribute("token");
        CookieUtls.removeCookie(response,"userName");
        CookieUtls.removeCookie(response,"password");
        return "redirect:/";
    }
}
