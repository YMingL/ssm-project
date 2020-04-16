package com.yang.shop.dto;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by acer on 2019-12-22.
 */
@Data
public class PageParam {

    private String goodsName;
    private Integer pageStart;
    private Integer pageSize;
    private String brandName;
    private String price;
    private Integer minPrice;
    private Integer maxPrice;

    public PageParam(String goodsName, Integer pageStart, Integer pageSize,String brandName,String price,int minPrice,int maxPrice) {
        this.goodsName = goodsName;
        this.pageStart = pageStart;
        this.pageSize = pageSize;
        this.brandName = brandName;
        this.price = price;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public PageParam(String goodsName, Integer pageStart, Integer pageSize,String brandName,String price) {
        this.goodsName = goodsName;
        this.pageStart = pageStart;
        this.pageSize = pageSize;
        this.brandName = brandName;
    }

    public static PageParam getInstance(String goodsName,Integer pageStart,Integer pageSize,String brandName,String price){
        if (price != null){
            int min,max;
            if(Pattern.compile("-").matcher(price).find()){
                String[] prices = price.split("-");
                min = Integer.parseInt(prices[0]);
                max = Integer.parseInt(prices[1]);
            }else {
                Matcher matcher = Pattern.compile("[^0-9]").matcher(price);
                min = Integer.parseInt(matcher.replaceAll("").trim());
                max = 99999;
            }
            System.out.println(min+":::"+max);
            return new PageParam(goodsName,pageStart,pageSize,brandName,price,min,max);
        }else {
            return new PageParam(goodsName,pageStart,pageSize,brandName,price);
        }

    }
}
