package com.webgraduation.dao;

import com.webgraduation.dto.SqlParams;
import com.webgraduation.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    int deleteByName(String userName);

    int insert(User record);

//    User selectById(String userId);

    int updateByName(User record);

    User selectByName(String userName);

    @Select("select goldNum from user where userName = #{userName}")
    int getUserGold(String userName);

    @Update("update user set goldNum = goldNum + #{goldNum} where userName = #{userName}")
    int updateUserGold(SqlParams sqlParams);

    @Select("select count(*) from user")
    int selectMaxId();
}
