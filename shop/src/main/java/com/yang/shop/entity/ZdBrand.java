package com.yang.shop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌字典
 */
@Data
public class ZdBrand implements Serializable {

    private static final long serialVersionUID = 3L;

    private int brandId;
    private String brandName;
}
