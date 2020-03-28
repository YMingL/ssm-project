package com.webgraduation.service.impl;

import com.webgraduation.dao.UserMapper;
import com.webgraduation.dto.SqlParams;
import com.webgraduation.entity.User;
import com.webgraduation.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.selectByName(userName);
    }

    @Override
    @Transactional(timeout = 10)
    public Integer insertUser(@Param("user") User user) {
        return userMapper.insert(user);
    }

    @Override
    @Transactional(timeout = 10)
    public Integer updateUser(User user) {
        return userMapper.updateByName(user);
    }

    @Override
    public Integer deleteUser(String userName) {
        return userMapper.deleteByName(userName);
    }

    @Override
    public Integer updateUserGold(SqlParams sqlParams) {
        return userMapper.updateUserGold(sqlParams);
    }

    @Override
    public Integer getMaxUserId() {
        return userMapper.selectMaxId();
    }
}
