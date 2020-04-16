package com.yang.shop.service.impl;

import com.yang.shop.entity.ZdBrand;
import com.yang.shop.service.ZdBrandService;
import org.springframework.stereotype.Service;

@Service
public class ZdBrandServiceImpl implements ZdBrandService {
    @Override
    public int deleteById(int brandId) {
        return 0;
    }

    @Override
    public int insertBrand(ZdBrand zdBrand) {
        return 0;
    }

    @Override
    public ZdBrand getBrand(int brandId) {
        return null;
    }
}
