package com.webgraduation.service;

import com.webgraduation.entity.Shop;

public interface ShopService {

    /**
     *
     * @param shopName
     * @return
     */
    public Shop getShopByName(String shopName);

    /**
     *
     * @param shopId
     * @return
     */
    public Shop getShopById(int shopId);

    /**
     *
     * @param shop
     * @return
     */
    public int insertShop(Shop shop);
}
