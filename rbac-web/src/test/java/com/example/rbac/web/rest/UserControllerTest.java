package com.example.rbac.web.rest;

import com.example.common.util.JsonUtil;
import com.example.rbac.help.DepartmentHelper;
import com.example.rbac.help.RoleHelper;
import com.example.rbac.help.UserHelper;
import com.example.rbac.pojo.dto.UserAddDTO;
import com.example.rbac.pojo.dto.UserUpdateDTO;
import com.example.rbac.pojo.po.DepartmentPO;
import com.example.rbac.pojo.po.RolePO;
import com.example.rbac.pojo.po.UserPO;
import com.example.rbac.web.AbstractWebTest;
import com.example.rbac.web.constant.WebConst;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 【用户】单元测试
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UserControllerTest extends AbstractWebTest {

    @Autowired
    private DepartmentHelper departmentHelper;
    @Autowired
    private RoleHelper roleHelper;
    @Autowired
    private UserHelper userHelper;


    /**
     * 新增【用户】
     */
    @Test
    public void save() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        UserAddDTO addDTO = userHelper.getUserAddDTO(department.getId());
        restMockMvc.perform(post(WebConst.API_PATH + "/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(status().isCreated());
    }

    /**
     * 修改【用户】
     */
    @Test
    public void update() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        UserPO user = userHelper.saveUserExample(department.getId());
        UserUpdateDTO updateDTO = userHelper.getUserUpdateDTO(user);
        restMockMvc.perform(put(WebConst.API_PATH + "/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(status().isOk());
    }

    /**
     * 分页查询【用户】
     */
    @Test
    public void list() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        UserPO user = userHelper.saveUserExample(department.getId());
        restMockMvc.perform(get(WebConst.API_PATH + "/user"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.list.length()").value(is(1)));
    }

    /**
     * 查看【用户】详情
     */
    @Test
    public void show() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        UserPO user = userHelper.saveUserExample(department.getId());
        restMockMvc.perform(get(WebConst.API_PATH + "/user/{id}", user.getId()))
            .andExpect(status().isOk());
    }

    /**
     * 删除单个【用户】
     */
    @Test
    public void del() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        UserPO user = userHelper.saveUserExample(department.getId());
        restMockMvc.perform(delete(WebConst.API_PATH + "/user/{id}", user.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }

    /**
     * 批量删除【用户】
     */
    @Test
    public void deleteBatch() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        UserPO user = userHelper.saveUserExample(department.getId());
        restMockMvc.perform(delete(WebConst.API_PATH + "/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(Lists.newArrayList(user.getId()))))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }



}
