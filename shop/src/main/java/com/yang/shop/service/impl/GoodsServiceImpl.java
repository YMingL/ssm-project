package com.yang.shop.service.impl;

import com.yang.shop.dao.GoodsMapper;
import com.yang.shop.dto.PageParam;
import com.yang.shop.entity.Goods;
import com.yang.shop.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getListGoods(String goodsName) {
        return goodsMapper.selectByGoodsName(goodsName);
    }

    @Override
    public List<Goods> getListOrderBySales(String goodsName) {
        return goodsMapper.selectOrderBySales(goodsName);
    }

    @Override
    public List<Goods> getPageList(PageParam pageParam) {
        return goodsMapper.selectListPage(pageParam);
    }

    @Override
    public int getGoodsNum(PageParam pageParam) {
        return goodsMapper.getGoodsNum(pageParam);
    }
}
