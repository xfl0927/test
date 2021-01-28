package com.example.rbac.web.rest;

import com.example.common.util.JsonUtil;
import com.example.rbac.help.ResourceHelper;
import com.example.rbac.pojo.dto.ResourceAddDTO;
import com.example.rbac.pojo.dto.ResourceUpdateDTO;
import com.example.rbac.pojo.po.ResourcePO;
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
 * 【资源】单元测试
 *
 * @author Jack
 * @date 2020/04/25
 */
public class ResourceControllerTest extends AbstractWebTest {

    @Autowired
    private ResourceHelper resourceHelper;


    /**
     * 新增【资源】
     */
    @Test
    public void save() throws Exception {
        ResourceAddDTO addDTO = resourceHelper.getResourceAddDTO();
        restMockMvc.perform(post(WebConst.API_PATH + "/resource")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(status().isCreated());
    }

    /**
     * 修改【资源】
     */
    @Test
    public void update() throws Exception {
        ResourcePO resource = resourceHelper.saveResourceExample();
        ResourceUpdateDTO updateDTO = resourceHelper.getResourceUpdateDTO(resource);
        restMockMvc.perform(put(WebConst.API_PATH + "/resource")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(status().isOk());
    }

    /**
     * 分页查询【资源】
     */
    @Test
    public void list() throws Exception {
        ResourcePO resource = resourceHelper.saveResourceExample();
        restMockMvc.perform(get(WebConst.API_PATH + "/resource"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.list.length()").value(is(1)));
    }

    /**
     * 查询【资源】选项列表
     */
    @Test
    public void findOptions() throws Exception {
        ResourcePO resource = resourceHelper.saveResourceExample();
        restMockMvc.perform(get(WebConst.API_PATH + "/resource/options"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    /**
     * 查看【资源】详情
     */
    @Test
    public void show() throws Exception {
        ResourcePO resource = resourceHelper.saveResourceExample();
        restMockMvc.perform(get(WebConst.API_PATH + "/resource/{id}", resource.getId()))
            .andExpect(status().isOk());
    }

    /**
     * 删除单个【资源】
     */
    @Test
    public void del() throws Exception {
        ResourcePO resource = resourceHelper.saveResourceExample();
        restMockMvc.perform(delete(WebConst.API_PATH + "/resource/{id}", resource.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }

    /**
     * 批量删除【资源】
     */
    @Test
    public void deleteBatch() throws Exception {
        ResourcePO resource = resourceHelper.saveResourceExample();
        restMockMvc.perform(delete(WebConst.API_PATH + "/resource")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(Lists.newArrayList(resource.getId()))))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }



}
