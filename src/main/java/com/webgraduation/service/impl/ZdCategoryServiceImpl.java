package com.webgraduation.service.impl;

import com.webgraduation.dao.ZdCategoryMapper;
import com.webgraduation.entity.ZdCategory;
import com.webgraduation.service.ZdCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
