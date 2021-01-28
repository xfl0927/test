package com.example.rbac.constant;

import com.example.common.validator.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举【性别】
 *
 * @author Jack
 * @date 2020/04/25
 */
public enum Sex {

    /**
     * 男
     */
    MAN(1,"男"),
    /**
     * 女
     */
    WOMAN(2,"女");


    private final Integer value;
    private final String desc;

    /**
     * 枚举值罗列，给swagger接口文档展示用
     */
    public static final String VALUES_STR = "1,2";

    private static final Map<Integer, Sex> LOOKUP = new HashMap<>();

    static {
        for (Sex e : Sex.values()) {
            LOOKUP.put(e.value, e);
        }
    }


    Sex(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static Sex find(Integer value) {
        return LOOKUP.get(value);
    }

    public static Sex findByDesc(String desc){
        for (Sex e : Sex.values()) {
            if(e.getDesc().equals(desc)){
                return e;
            }
        }
        return null;
    }


    /**
     * desc映射value
     *
     * @param desc
     * @return
     */
    public static Integer descToValue(String desc) {
        Sex theEnum = findByDesc(desc);
        if (theEnum != null) {
            return theEnum.getValue();
        }
        return null;
    }

    /**
     * value映射desc
     *
     * @param value
     * @return
     */
    public static String valueToDesc(Integer value) {
        Sex theEnum = find(value);
        if (theEnum != null) {
            return theEnum.getDesc();
        }
        return null;
    }

    /**
     * 校验有效性
     */
    @Check
    public static final boolean validate(Integer value){
        Sex theEnum = find(value);
        return theEnum!=null;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


}

