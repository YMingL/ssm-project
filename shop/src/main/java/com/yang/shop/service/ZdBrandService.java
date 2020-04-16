package com.yang.shop.service;

import com.yang.shop.entity.ZdBrand;

public interface ZdBrandService {

    /**
     *
     * @param brandId
     * @return
     */
    public int deleteById(int brandId);

    /**
     *
     * @param zdBrand
     * @return
     */
    public int insertBrand(ZdBrand zdBrand);

    /**
     *
     * @param brandId
     * @return
     */
    public ZdBrand getBrand(int brandId);
}
