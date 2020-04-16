package com.yang.shop.config;

import com.yang.shop.interceptor.LoginVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginVerifyInterceptor()).addPathPatterns("/*.html","/publicPage/*.html")
                .excludePathPatterns("/","/index.html","/regist.html","/registSuccess.html","/*/*.js","/*/*.css");
    }
}
