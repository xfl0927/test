package com.example.common.util;

import java.math.BigDecimal;

/**
 * 空指针安全的类型转换工具
 *
 * @author Jack
 * @date 2020/04/25
 */
public class SafeUtil {

    /**
     * 对象转Integer
     * @param obj
     * @return
     */
    public static Integer getInteger(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return Integer.valueOf(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 对象转Long
     * @param obj
     * @return
     */
    public static Long getLong(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return Long.valueOf(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 对象转Short
     * @param obj
     * @return
     */
    public static Short getShort(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return Short.valueOf(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 对象转Double
     * @param obj
     * @return
     */
    public static Double getDouble(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return Double.valueOf(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 对象转BigDecimal
     * @param obj
     * @return
     */
    public static BigDecimal getBigDecimal(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return new BigDecimal(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 对象转Float
     * @param obj
     * @return
     */
    public static Float getFloat(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return Float.valueOf(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 对象转Boolean
     * @param obj
     * @return
     */
    public static Boolean getBoolean(Object obj){
        if(obj==null){
            return null;
        }
        try {
            return Boolean.valueOf(obj.toString());
        }catch (Exception e){}
        return null;
    }
    /**
     * 转字符串
     * @param obj
     * @return
     */
    public static String getString(Object obj){
        return obj==null?null:obj.toString();
    }


}

