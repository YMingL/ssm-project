package com.webgraduation.controller;

import com.webgraduation.entity.User;
import com.webgraduation.service.UserService;
import com.webgraduation.util.redisUtil.impl.UserInfoRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoRedis userRedisTask;

    /**
     * 判断是否有重复名称
     * @param userName
     * @return 0 代表库中有此姓名 1 代表没有
     */
    @RequestMapping("/hasUserName")
    @ResponseBody
    public Integer hasUserName(@RequestParam("userName") String userName){
        if(userService.getUserByName(userName) == null){
            return 0;
        }
        return 1;
    }

    /**
     * 注册用户
     * @param user
     * @return flag为0时即用户名已注册
     */
    @RequestMapping("/registUser")
    @ResponseBody
    public Integer registUser(User user){
        Integer flag = userService.insertUser(user);
        return  flag;
    }

    /**
     * 更新用户信息
     * @param user
     * @return flag为0时更新失败
     */
    @ResponseBody
    @RequestMapping("/upateUser")
    public Integer updateUser(User user){
        Integer flag = userService.updateUser(user);
        return flag;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public Integer deleteUser(String userId){
        Integer flag = userService.deleteUser(userId);
        return flag;
    }
}

