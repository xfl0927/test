package com.example.rbac.constant;

import com.example.common.validator.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举【资源类型】
 *
 * @author Jack
 * @date 2020/04/25
 */
public enum ResType {

    /**
     * 菜单组
     */
    MENU_GROUP(1,"菜单组"),
    /**
     * 菜单
     */
    MENU(2,"菜单"),
    /**
     * 按钮
     */
    BUTTON(3,"按钮"),
    /**
     * 请求
     */
    REQUEST(4,"请求"),
    /**
     * 其他
     */
    OTHER(9,"其他");


    private final Integer value;
    private final String desc;

    /**
     * 枚举值罗列，给swagger接口文档展示用
     */
    public static final String VALUES_STR = "1,2,3,4,9";

    private static final Map<Integer, ResType> LOOKUP = new HashMap<>();

    static {
        for (ResType e : ResType.values()) {
            LOOKUP.put(e.value, e);
        }
    }


    ResType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ResType find(Integer value) {
        return LOOKUP.get(value);
    }

    public static ResType findByDesc(String desc){
        for (ResType e : ResType.values()) {
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
        ResType theEnum = findByDesc(desc);
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
        ResType theEnum = find(value);
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
        ResType theEnum = find(value);
        return theEnum!=null;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


}

