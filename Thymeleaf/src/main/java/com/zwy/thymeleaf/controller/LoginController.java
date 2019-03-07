package com.zwy.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public String login(String userName, String password, Model model) {
        model.addAttribute("userName",userName);

        return "success";
    }

    @RequestMapping(value = "/tologin2",method = RequestMethod.POST)
    public ModelAndView login2(String userName, String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName",userName);
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
