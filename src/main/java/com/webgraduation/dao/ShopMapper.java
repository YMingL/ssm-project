package com.webgraduation.dao;

import com.webgraduation.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMapper {

    /**
     * 根据id查询
     */

    Shop selectById(int shopId);

    /**
     * 根据店铺名查询
     */
    Shop selectByName(String shopName);

    /**
     * 插入店铺
     * @param shop
     * @return
     */
    int insert(Shop shop);
}
