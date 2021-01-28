package com.example.common.optimistic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 乐观锁配置
 *
 * @author Jack
 * @date 2020/04/25
 */
public class OptimisticLockConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(OptimisticLockConfiguration.class);

    @Bean
    public OptimisticLockAspect optimisticLockAspect() {
        logger.info("创建OptimisticLockAspect");
        return new OptimisticLockAspect();
    }

}

