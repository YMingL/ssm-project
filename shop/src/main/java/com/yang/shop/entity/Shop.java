package com.yang.shop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 店铺类
 */
@Data
public class Shop implements Serializable {

    private static final long serialVersionUID = 5L;

    private int shopId;
    private String shopName;
    private String shopProvince;
    private String shopAddress;
}
