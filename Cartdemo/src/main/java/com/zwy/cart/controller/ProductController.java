package com.zwy.cart.controller;

import com.zwy.cart.bean.ProductBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductController {
    private static ArrayList<ProductBean> list = new ArrayList<>();

    static {
        list.add(new ProductBean(1, "红米手机", 1200));
        list.add(new ProductBean(2, "华为荣耀", 1800));
        list.add(new ProductBean(3, "大话设计模式", 68));
        list.add(new ProductBean(4, "Android进阶解密", 80));
        list.add(new ProductBean(5, "Android进阶解密", 80));
        list.add(new ProductBean(6, "一加手机", 3500));
    }

    @RequestMapping("/product/list")
    public String productList(Model model) {
        model.addAttribute("products", list);
        return "product_list";
    }

    @RequestMapping("/product/add")
    public String addCart(int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ProductBean bean = null;
        for (ProductBean productBean : list) {
            if (productBean.getId() == id){
                bean = productBean;
                break;
            }
        }
       HashMap<ProductBean,Integer> map= (HashMap<ProductBean, Integer>) session.getAttribute("cart");
        if (map == null){
            map = new HashMap<>();
        }
        if (map.containsKey(bean)){
            map.put(bean,map.get(bean)+1);
        }else {
            map.put(bean,1);
        }
        session.setAttribute("cart",map);
        return "redirect:/cart/success.html";
    }
}
