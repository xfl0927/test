package com.example.rbac.web;

import com.example.rbac.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * web单元测试抽象类
 *
 * @author Jack
 * @date 2020/04/25
 */
@AutoConfigureMockMvc(printOnlyOnFailure=false)
public abstract class AbstractWebTest extends AbstractTest {

    @Autowired
    protected MockMvc restMockMvc;

}

