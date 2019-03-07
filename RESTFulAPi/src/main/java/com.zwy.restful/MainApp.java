package com.zwy.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/***
 * 业务流程分析
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
