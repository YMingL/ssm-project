package com.webgraduation.service.impl;

import com.webgraduation.dao.GoodsMapper;
import com.webgraduation.dto.PageParam;
import com.webgraduation.entity.Goods;
import com.webgraduation.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

//    @Autowired(required = false)
    private GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper){
        this.goodsMapper = goodsMapper;
    }

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
