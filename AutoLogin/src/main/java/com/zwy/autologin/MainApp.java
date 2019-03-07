package com.zwy.autologin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/***
 * 业务流程分析
 * 1，访问index，任何人都可以访问index
 * 2，通过index访问cart页面,访问cart页面必须登陆
 * 3，首先判断是否登陆，没有登陆的话判断是否自动
 * 4，如果不自动登陆，跳转到登陆页面
 *
 */


@ServletComponentScan
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        //这行代码让我们项目运行起来
        SpringApplication.run(MainApp.class, args);
    }
}
