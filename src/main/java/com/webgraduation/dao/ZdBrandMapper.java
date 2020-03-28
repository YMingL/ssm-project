package com.webgraduation.dao;

import com.webgraduation.entity.ZdBrand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZdBrandMapper {

    @Delete("delete from zdbrand where brandId = #{brandId}")
    int deleteById(int brandId);

    int insert(ZdBrand record);

    ZdBrand selectById(int brandId);
}
