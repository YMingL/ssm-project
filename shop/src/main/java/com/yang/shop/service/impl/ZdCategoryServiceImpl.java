package com.yang.shop.service.impl;

import com.yang.shop.dao.ZdCategoryMapper;
import com.yang.shop.entity.ZdCategory;
import com.yang.shop.service.ZdCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZdCategoryServiceImpl implements ZdCategoryService {

    @Autowired
    private ZdCategoryMapper zdCategoryMapper;

    @Override
    public int deleteCategoryById(int categoryId) {
        return 0;
    }

    @Override
    public int insertCategory(ZdCategory zdCategory) {
        return 0;
    }

    @Override
    public ZdCategory getCategoryById(int categoryId) {
        return null;
    }

    @Override
    public int updateCategoryById(ZdCategory zdCategory) {
        return 0;
    }

    @Override
    public List<ZdCategory> getCategoryList() {
        return zdCategoryMapper.selectCategoryList();
    }
}
