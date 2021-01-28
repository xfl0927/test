package com.example.rbac.pojo.vo;

import com.example.common.constant.JsonFieldConst;
import com.example.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import static com.example.rbac.pojo.example.RoleExample.*;

/**
 * 【角色】列表展示对象
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "【角色】列表展示对象")
public class RoleListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Long id;

    @ApiModelProperty(notes = N_CODE, example = E_CODE)
    private String code;

    @ApiModelProperty(notes = N_ROLE_NAME, example = E_ROLE_NAME)
    private String roleName;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date operatedTime;


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

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getOperatedTime() {
        return this.operatedTime;
    }

    public void setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
    }



}

