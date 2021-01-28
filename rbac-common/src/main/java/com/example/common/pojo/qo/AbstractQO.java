package com.example.common.pojo.qo;

import com.example.common.util.JsonUtil;

import java.io.Serializable;

/**
 * 数据查询参数对象超类
 *
 * @author Jack
 * @date 2020/04/25
 */
public abstract class AbstractQO implements Serializable {

    private static final long serialVersionUID = -2460649808778841614L;

    @Override
    public String toString() {
        return JsonUtil.toJSONString(this);
    }

}

