package com.example.rbac;

import com.example.rbac.web.rest.DepartmentControllerTest;
import com.example.rbac.web.rest.ResourceControllerTest;
import com.example.rbac.web.rest.RoleControllerTest;
import com.example.rbac.web.rest.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 合并测试类
 *
 * @author Jack
 * @date 2020/04/25
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    UserControllerTest.class,
    RoleControllerTest.class,
    ResourceControllerTest.class,
    DepartmentControllerTest.class,
})
public class Main {


}

