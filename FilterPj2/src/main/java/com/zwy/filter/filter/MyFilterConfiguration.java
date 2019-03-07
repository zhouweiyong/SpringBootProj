package com.zwy.filter.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfiguration {

    @Bean("bean1")
    public FilterRegistrationBean registrationBean1() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter1());
        bean.addUrlPatterns("/content1/*");
        bean.setOrder(2);
        return bean;
    }

    @Bean("bean2")
    public FilterRegistrationBean registrationBean2() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }

}
