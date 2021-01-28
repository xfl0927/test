package com.example.common.optimistic;


/**
 * 乐观锁异常
 *
 * @author Jack
 * @date 2020/04/25
 */
public class OptimisticException extends RuntimeException {

    public OptimisticException() {

    }

    public OptimisticException(String message) {
        super(message);
    }
}

