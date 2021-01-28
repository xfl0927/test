package com.example.common.pojo.dto;

import com.example.common.util.JsonUtil;

import java.io.Serializable;

/**
 * 数据传输对象超类
 *
 * @author Jack
 * @date 2020/04/25
 */
public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = 1915714417292764241L;

    @Override
    public String toString() {
        return JsonUtil.toJSONString(this);
    }

}

