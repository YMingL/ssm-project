package com.yang.shop.dao;

import com.yang.shop.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
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
