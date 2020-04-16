package com.yang.shop.dao;

import com.yang.shop.dto.SqlParams;
import com.yang.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
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
