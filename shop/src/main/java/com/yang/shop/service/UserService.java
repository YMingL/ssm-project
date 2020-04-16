package com.yang.shop.service;

import com.yang.shop.dto.SqlParams;
import com.yang.shop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by acer on 2019-12-23.
 */
public interface UserService {

    /**
     * 获取用户信息
     */
    User getUserById(String userId);

    User getUserByName(String userName);

    /*
     * 添加用户 注册
     * */
    Integer insertUser(@Param("user") User user);

    /*
     * 更新用户信息
     * */
    Integer updateUser(User user);

    /**
     * 注销用户
     * @param userName
     * @return
     */
    Integer deleteUser(String userName);

    /**
     * 更新用户金币数
     * @param sqlParams
     * @return
     */
    Integer updateUserGold(SqlParams sqlParams);

    /**
     * 获取最大的用户Id
     * @return
     */
    Integer getMaxUserId();
}
