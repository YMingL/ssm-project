package com.webgraduation.service.impl;

import com.webgraduation.entity.ZdBrand;
import com.webgraduation.service.ZdBrandService;
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
