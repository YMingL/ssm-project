package com.webgraduation.service;

import com.webgraduation.entity.ZdCategory;

import java.util.List;

public interface ZdCategoryService {
    /**
     *
     * @param categoryId
     * @return
     */
    public int deleteCategoryById(int categoryId);

    /**
     *
     * @param zdCategory
     * @return
     */
    public int insertCategory(ZdCategory zdCategory);

    /**
     *
     * @param categoryId
     * @return
     */
    public ZdCategory getCategoryById(int categoryId);

    /**
     *
     * @param zdCategory
     * @return
     */
    public int updateCategoryById(ZdCategory zdCategory);

    /**
     *
     * @return
     */
    public List<ZdCategory> getCategoryList();
}
