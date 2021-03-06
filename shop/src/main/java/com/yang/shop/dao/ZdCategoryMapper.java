package com.yang.shop.dao;

import com.yang.shop.entity.ZdCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ZdCategoryMapper {

    @Delete("delete from zdcategory where categoryId = #{categoryId}")
    int deleteById(int categoryId);
//    int deleteByListId(ArrayList<Integer> categoryList);
    @Insert("insert into zdcategory (categoryId,categoryName,categoryLevel,categoryGroup) values " +
            "(#{categoryId},#{categoryName},#{categoryLevel},#{categoryGroup.categoryId})")
    int insert(ZdCategory record);

    ZdCategory selectById(int categoryId);

    @Update("update zdcategory set categoryName=#{categoryName},categoryLevel=#{categoryLevel},categoryGroup=#{categoryGroup.categoryId} where categoryId = #{categoryId}")
    int updateById(ZdCategory record);

    List<ZdCategory> selectCategoryList();
}
