package com.zwy.autologin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShopController {

    @RequestMapping("/cart")
    public String cart(HttpServletRequest request) {
        return "cart_view";
    }
}
