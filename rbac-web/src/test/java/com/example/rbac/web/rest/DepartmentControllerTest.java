package com.example.rbac.web.rest;

import com.example.common.util.JsonUtil;
import com.example.rbac.help.DepartmentHelper;
import com.example.rbac.pojo.dto.DepartmentAddDTO;
import com.example.rbac.pojo.dto.DepartmentUpdateDTO;
import com.example.rbac.pojo.po.DepartmentPO;
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
 * 【部门】单元测试
 *
 * @author Jack
 * @date 2020/04/25
 */
public class DepartmentControllerTest extends AbstractWebTest {

    @Autowired
    private DepartmentHelper departmentHelper;


    /**
     * 新增【部门】
     */
    @Test
    public void save() throws Exception {
        DepartmentAddDTO addDTO = departmentHelper.getDepartmentAddDTO();
        restMockMvc.perform(post(WebConst.API_PATH + "/department")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(status().isCreated());
    }

    /**
     * 修改【部门】
     */
    @Test
    public void update() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        DepartmentUpdateDTO updateDTO = departmentHelper.getDepartmentUpdateDTO(department);
        restMockMvc.perform(put(WebConst.API_PATH + "/department")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(status().isOk());
    }

    /**
     * 分页查询【部门】
     */
    @Test
    public void list() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        restMockMvc.perform(get(WebConst.API_PATH + "/department"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.list.length()").value(is(1)));
    }

    /**
     * 查询【部门】选项列表
     */
    @Test
    public void findOptions() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        restMockMvc.perform(get(WebConst.API_PATH + "/department/options"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    /**
     * 查看【部门】详情
     */
    @Test
    public void show() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        restMockMvc.perform(get(WebConst.API_PATH + "/department/{id}", department.getId()))
            .andExpect(status().isOk());
    }

    /**
     * 删除单个【部门】
     */
    @Test
    public void del() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        restMockMvc.perform(delete(WebConst.API_PATH + "/department/{id}", department.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }

    /**
     * 批量删除【部门】
     */
    @Test
    public void deleteBatch() throws Exception {
        DepartmentPO department = departmentHelper.saveDepartmentExample();
        restMockMvc.perform(delete(WebConst.API_PATH + "/department")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(Lists.newArrayList(department.getId()))))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }



}
