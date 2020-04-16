package com.yang.shop.dao;

import com.yang.shop.entity.ZdBrand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ZdBrandMapper {

    @Delete("delete from zdbrand where brandId = #{brandId}")
    int deleteById(int brandId);

    int insert(ZdBrand record);

    ZdBrand selectById(int brandId);
}
