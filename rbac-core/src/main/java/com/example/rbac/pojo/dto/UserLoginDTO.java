package com.example.rbac.pojo.dto;


/**
 * 用户登录请求体
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UserLoginDTO {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

