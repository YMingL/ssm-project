package com.yang.shop.service.impl;

import com.yang.shop.dao.UserMapper;
import com.yang.shop.dto.SqlParams;
import com.yang.shop.entity.User;
import com.yang.shop.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@CacheConfig(cacheManager = "cacheManager")
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Cacheable(cacheNames = "userInfo",key = "#userName+'_info'", unless = "#result==null")
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
