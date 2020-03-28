package com.webgraduation.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2L;

    private int userId; //用户id
    private String userName; //用户名
    private String password; //密码
    private String mail; //邮箱
    private String phone; //电话
    private int goldNum; //金币数
    private int level; //用户级别
    private String address; //用户地址

    public User() {
    }

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public User(int userId, String userName, String password, String mail, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }
}
