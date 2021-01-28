package com.example.rbac.web.context;

import com.example.common.context.LoginContext;
import org.springframework.stereotype.Component;

/**
 * web登录用户上下文
 *
 * @author Jack
 * @date 2020/04/25
 */
@Component
public class WebLoginContext implements LoginContext{

    /**
     * 获取当前操作员id
     * @return
     */
    @Override
    public String getCurrentUser() {
        return "admin";
    }

}

