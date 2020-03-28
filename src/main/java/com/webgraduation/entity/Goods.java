package com.webgraduation.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *商品类
 */

@Data
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private int goodsId; //商品id
    private String goodsUrl; //商品URL
    private String goodsName; //商品名
    private String origPrice; //原价
    private String currPrice; //现价
    private int sales; //销量
    private String goodsImgUrl; //商品图片URL
    private String brandName; //品牌名
    private String shopName; //店铺名
    private List<ZdCategory> category; //商品分类

}
