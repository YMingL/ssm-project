package com.webgraduation.service;

import com.webgraduation.dto.PageParam;
import com.webgraduation.entity.Goods;

import java.util.List;

/**
 * Created by acer on 2019-12-08.
 */
public interface GoodsService {

    /**
     *获得商品列表 根据商品名查询
     *
     */
    List<Goods> getListGoods(String goodsName);

    /**
     * 根据销量排序
     */
    List<Goods> getListOrderBySales(String goodsName);

    /**
     * 实现分页显示
     * @param pageParam
     * @return 商品列表
     */
    List<Goods> getPageList(PageParam pageParam);

    /**
     * 获取相关商品总数
     * @param pageParam
     * @return
     */
    int getGoodsNum(PageParam pageParam);

}
