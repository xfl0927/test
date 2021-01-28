package com.example.common.context;


/**
 * 登录上下文接口
 *
 * @author Jack
 * @date 2020/04/25
 */
public interface LoginContext {

    /**
     * 获取当前登录用户唯一标识
     *
     * @return 用户唯一标识
     */
    String getCurrentUser();

}

