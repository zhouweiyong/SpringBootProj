package com.zwy.cart.controller;

import com.zwy.cart.bean.ProductBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CartController {

    @RequestMapping("/cart/show")
    public String showCart(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        HashMap<ProductBean, Integer> map = (HashMap<ProductBean, Integer>) session.getAttribute("cart");
        for (ProductBean productBean : map.keySet()) {
            System.out.println(""+productBean.getName());
        }
        model.addAttribute("carts", map);
        return "/cart/show";
    }
}
