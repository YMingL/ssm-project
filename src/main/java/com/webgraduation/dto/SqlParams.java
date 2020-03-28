package com.webgraduation.dto;

import lombok.Data;

@Data
public class SqlParams {
    //用户姓名
    String userName;
    //新增金币数
    Integer goldNum;

    public SqlParams(String userName, Integer goldNum) {
        this.userName = userName;
        this.goldNum = goldNum;
    }
}
