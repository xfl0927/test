package com.example.common.optimistic;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用乐观锁
 *
 * @author Jack
 * @date 2020/04/25
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({OptimisticLockConfiguration.class})
public @interface EnableOptimisticLock {


}

