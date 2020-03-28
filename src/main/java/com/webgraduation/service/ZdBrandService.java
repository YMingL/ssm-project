package com.webgraduation.service;

import com.webgraduation.entity.ZdBrand;

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
