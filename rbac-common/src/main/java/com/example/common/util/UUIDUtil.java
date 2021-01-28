package com.example.common.util;

import java.util.UUID;

/**
 * 获取UUID
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UUIDUtil {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static String getUUID16() {
        return getUUID().substring(8,24);
    }

}

