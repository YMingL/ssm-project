package com.yang.shop.dto;

import java.io.Serializable;

public class UserGoldInfo implements Serializable {

    private static final long serialVersionUID = 6L;
    //上次登陆时间
    private long millis;

    //该周每天的金币数
    private int[] goldNums =new int[7];

    public int[] getGoldNums() {
        return goldNums;
    }
    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }


    public int getGoldNum(int i){
        if(i == 0){
            return goldNums[6];
        }else {
            return goldNums[i-1];
        }
    }

    public void setGoldNum(int i,int num){
        if (i==0){
            goldNums[6] = num;
        }else {
            goldNums[i-1] = num;
        }
    }

    public void empty(){
        for (int i=0;i<7;i++){
            goldNums[i] = 0;
        }
    }

}
