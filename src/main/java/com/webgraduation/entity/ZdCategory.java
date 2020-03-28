package com.webgraduation.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分类字典
 */
@Data
public class ZdCategory implements Serializable {

    private static final long serialVersionUID = 4L;

    private int categoryId; //分类id
    private String categoryName; //分类名
    private int categoryLevel; //分类级别 目前设置二级分类
    private ZdCategory categoryGroup; //父分类
}
