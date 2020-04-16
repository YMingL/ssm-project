package com.yang.shop.Controller;


import com.yang.shop.entity.User;
import com.yang.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户功能
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/savingUsesr")
    @ResponseBody
    public Integer addUser(HttpServletRequest request, HttpServletResponse response){
//        校验通过后保存，此处省略检验
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        int userId = userService.getMaxUserId()+1;
        User user = new User(userId,userName,password,mail,phone);
        //先判断用户是否存在再保存，此处省略判断
        int flag = userService.insertUser(user);
        //添加异常
        return flag;
    }
}
