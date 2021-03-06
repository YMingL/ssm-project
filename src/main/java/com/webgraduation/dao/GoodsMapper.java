package com.webgraduation.dao;

import com.webgraduation.dto.PageParam;
import com.webgraduation.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    /*
     *
     * 根据id查询
     * */
    Goods selectById(int goodsId);

    /*
     * 根据商品名查询
     * 默认排序
     * */
    List<Goods> selectByGoodsName(String goodsName);

    /*
     * 根据销量排序
     * 仍然根据商品名查询
     * */
    List<Goods> selectOrderBySales(String goodsName);

    /*
     * 分页
     * */
    List<Goods> selectListPage(PageParam pageParam);

    /**
     * 单个插入
     * @param goods
     * @return
     */
    int inert(@Param(value = "goods") Goods goods);

    /**
     * 多个插入
     * @param goodsList
     * @return
     */
    int insertList(@Param("goodsList") List<Goods> goodsList);

    int deleteList();

    int getGoodsNum(PageParam pageParam);
}
