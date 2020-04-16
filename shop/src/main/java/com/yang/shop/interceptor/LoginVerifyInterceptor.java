package com.yang.shop.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by acer on 2020-01-29.
 */
public class LoginVerifyInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //根据session来判断用户是否登陆
        logger.error("进入拦截器。。。。");
        if(request.getSession().getAttribute("user") == null){
            if(request.getHeader("X-Requested-With") == null){
                response.sendRedirect(request.getContextPath()+"/index.html");
                logger.error("退出拦截器。。。。1");
                return false;
            }else if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")){
                ServletOutputStream out = response.getOutputStream();
                out.print("-2");
                out.flush();
                out.close();
                logger.error("退出拦截器。。。2");
                return false;
            }

        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
