package com.example.common.xss;

import java.lang.annotation.*;

/**
 * 无视XSS脚本
 *
 * @author Jack
 * @date 2020/04/25
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IgnoreXSS {


}

