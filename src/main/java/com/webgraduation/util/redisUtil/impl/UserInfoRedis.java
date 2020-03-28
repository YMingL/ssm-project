package com.webgraduation.util.redisUtil.impl;


import com.webgraduation.entity.User;
import com.webgraduation.util.redisUtil.RedisBaiseTakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component("UserInfoRedis")
public class UserInfoRedis implements RedisBaiseTakes<String,String, User> {

    @Autowired
    private RedisTemplate redisTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(UserInfoRedis.class));

    @Override
    public void add(String key, String value) {
        if (redisTemplate == null){
            logger.warning("redisTemplate实例化失败!");
            return;
        }else {
            redisTemplate.opsForValue().set(key,value);
        }
    }

    @Override
    public void addObj(String objectKey, String key, User object) {
        if (redisTemplate == null){
            logger.warning("redisTemplate实例化失败！");
            return;
        }else {
            redisTemplate.opsForHash().put(objectKey,key,object);
            return;
        }
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void delete(List<String> listKeys) {

    }

    @Override
    public void deletObj(String objecyKey, String key) {

    }

    @Override
    public void update(String key, String value) {

    }

    @Override
    public void updateObj(String objectKey, String key, User object) {

    }

    @Override
    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public User getObj(String objectKey, String key) {
        User user = (User) redisTemplate.opsForHash().get(objectKey,key);
        return user;
    }
}

