package com.example.rbac.web.api;

import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.pojo.dto.RoleAddDTO;
import com.example.rbac.pojo.dto.RoleUpdateDTO;
import com.example.rbac.pojo.qo.RoleQO;
import com.example.rbac.pojo.vo.RoleListVO;
import com.example.rbac.pojo.vo.RoleShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 【角色】API
 * <p>swagger接口文档
 *
 * @author Jack
 * @date 2020/04/25
 */
@Api(tags = "【角色】API")
public interface RoleAPI {

    /**
     * 新增【角色】
     */
    @ApiOperation(value="新增【角色】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "roleAddDTO", dataType = "RoleAddDTO", value = "新增【角色】参数", paramType = "body"),
    })
    ResponseEntity<RoleShowVO> save(RoleAddDTO roleAddDTO) throws Exception;

    /**
     * 修改【角色】
     */
    @ApiOperation(value="修改【角色】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "roleUpdateDTO", dataType = "RoleUpdateDTO", value = "修改【角色】参数", paramType = "body"),
    })
    ResponseEntity<RoleShowVO> update(RoleUpdateDTO roleUpdateDTO);

    /**
     * 分页查询【角色】
     */
    @ApiOperation(value="分页查询【角色】")
    ResponseEntity<PageVO<RoleListVO>> list(RoleQO roleQO);

    /**
     * 查询【角色】选项列表
     */
    @ApiOperation(value = "查询【角色】选项列表")
    ResponseEntity<List<OptionVO<Long, String>>> findOptions(OptionQO<Long, String> qo);

    /**
     * 查看【角色】详情
     */
    @ApiOperation(value="查看【角色】详情")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "Long", value = "【角色】id", paramType = "path"),
    })
    ResponseEntity<RoleShowVO> show(Long id);

    /**
     * 删除单个【角色】
     */
    @ApiOperation(value="删除单个【角色】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "Long", value = "【角色】id", paramType = "path"),
    })
    ResponseEntity<Integer> delete(Long id);

    /**
     * 批量删除【角色】
     */
    @ApiOperation(value = "批量删除【角色】")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "Long", value = "id数组", paramType = "body"),
    })
    ResponseEntity<Integer> deleteBatch(Long[] id);

}

