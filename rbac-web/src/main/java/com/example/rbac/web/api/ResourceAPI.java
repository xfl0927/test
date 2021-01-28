package com.example.rbac.web.api;

import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.pojo.dto.ResourceAddDTO;
import com.example.rbac.pojo.dto.ResourceUpdateDTO;
import com.example.rbac.pojo.qo.ResourceQO;
import com.example.rbac.pojo.vo.ResourceListVO;
import com.example.rbac.pojo.vo.ResourceShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 【资源】API
 * <p>swagger接口文档
 *
 * @author Jack
 * @date 2020/04/25
 */
@Api(tags = "【资源】API")
public interface ResourceAPI {

    /**
     * 新增【资源】
     */
    @ApiOperation(value="新增【资源】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "resourceAddDTO", dataType = "ResourceAddDTO", value = "新增【资源】参数", paramType = "body"),
    })
    ResponseEntity<ResourceShowVO> save(ResourceAddDTO resourceAddDTO) throws Exception;

    /**
     * 修改【资源】
     */
    @ApiOperation(value="修改【资源】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "resourceUpdateDTO", dataType = "ResourceUpdateDTO", value = "修改【资源】参数", paramType = "body"),
    })
    ResponseEntity<ResourceShowVO> update(ResourceUpdateDTO resourceUpdateDTO);

    /**
     * 分页查询【资源】
     */
    @ApiOperation(value="分页查询【资源】")
    ResponseEntity<PageVO<ResourceListVO>> list(ResourceQO resourceQO);

    /**
     * 查询【资源】选项列表
     */
    @ApiOperation(value = "查询【资源】选项列表")
    ResponseEntity<List<OptionVO<Integer, String>>> findOptions(OptionQO<Integer, String> qo);

    /**
     * 查看【资源】详情
     */
    @ApiOperation(value="查看【资源】详情")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "int", value = "【资源】id", paramType = "path"),
    })
    ResponseEntity<ResourceShowVO> show(Integer id);

    /**
     * 删除单个【资源】
     */
    @ApiOperation(value="删除单个【资源】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "int", value = "【资源】id", paramType = "path"),
    })
    ResponseEntity<Integer> delete(Integer id);

    /**
     * 批量删除【资源】
     */
    @ApiOperation(value = "批量删除【资源】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "int", value = "id数组", paramType = "body"),
    })
    ResponseEntity<Integer> deleteBatch(Integer[] id);

}

