package com.example.rbac.pojo.vo;

import com.example.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import static com.example.rbac.pojo.example.RoleExample.*;

/**
 * 【角色】详情展示对象
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "【角色】详情展示对象")
public class RoleShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID,example = E_ID)
    private Long id;

    @ApiModelProperty(notes = N_CODE,example = E_CODE)
    private String code;

    @ApiModelProperty(notes = N_ROLE_NAME,example = E_ROLE_NAME)
    private String roleName;

    @ApiModelProperty(notes = "【资源】主键列表")
    private List<Integer> resourceList;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Integer> getResourceList() {
        return this.resourceList;
    }

    public void setResourceList(List<Integer> resourceList) {
        this.resourceList = resourceList;
    }



}

