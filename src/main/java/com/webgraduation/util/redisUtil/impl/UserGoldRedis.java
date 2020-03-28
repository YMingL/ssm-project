package com.webgraduation.util.redisUtil.impl;

import com.webgraduation.util.redisUtil.RedisBaiseTakes;
import com.webgraduation.dto.UserGoldInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Component("UserGoldRedis")
public class UserGoldRedis implements RedisBaiseTakes<String,String, UserGoldInfo> {

    @Resource
    private RedisTemplate redisTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(UserGoldRedis.class));

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
    public void addObj(String objectKey, String key, UserGoldInfo object) {
        if (redisTemplate == null){
            logger.warning("redisTemplate实例化失败！");
            return;
        }else {
            redisTemplate.opsForHash().put(objectKey,key,object);
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
        redisTemplate.opsForHash().delete(objecyKey,key);
    }

    @Override
    public void update(String key, String value) {

    }

    @Override
    public void updateObj(String objectKey, String key, UserGoldInfo object) {
        deletObj(objectKey,key);
        addObj(objectKey,key,object);
    }

    @Override
    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public UserGoldInfo getObj(String objectKey, String key) {
        try {
            UserGoldInfo obj =  (UserGoldInfo) redisTemplate.opsForHash().get(objectKey,key);
            return obj;
        }catch (Error e){
            e.printStackTrace();
        }
        return null;
    }
}
