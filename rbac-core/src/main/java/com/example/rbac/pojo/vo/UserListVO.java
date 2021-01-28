package com.example.rbac.pojo.vo;

import com.example.common.constant.JsonFieldConst;
import com.example.common.pojo.vo.AbstractVO;
import com.example.rbac.constant.Sex;
import com.example.rbac.pojo.example.RoleExample;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

import static com.example.rbac.pojo.example.UserExample.*;

/**
 * 【用户】列表展示对象
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "【用户】列表展示对象")
public class UserListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Long id;

    @ApiModelProperty(notes = N_SS, example = E_SS, allowableValues = Sex.VALUES_STR)
    private String ss;

    @ApiModelProperty(notes = N_USERNAME, example = E_USERNAME)
    private String username;

    @ApiModelProperty(notes = N_NICKNAME, example = E_NICKNAME)
    private String nickname;

    @ApiModelProperty(notes = N_SEX, example = E_SEX, allowableValues = Sex.VALUES_STR)
    private Integer sex;

    @ApiModelProperty(notes = N_DEPT_ID, example = E_DEPT_ID)
    private Integer deptId;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date operatedTime;

    @ApiModelProperty(notes = "【角色】列表")
    private List<RoleVO> roleList;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSs() {
        return this.ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public List<RoleVO> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(List<RoleVO> roleList) {
        this.roleList = roleList;
    }


    public static class RoleVO extends AbstractVO {

        @ApiModelProperty(notes = RoleExample.N_ID,example = RoleExample.E_ID)
        private Long id;

        @ApiModelProperty(notes = RoleExample.N_CODE,example = RoleExample.E_CODE)
        private String code;

        @ApiModelProperty(notes = RoleExample.N_ROLE_NAME,example = RoleExample.E_ROLE_NAME)
        private String roleName;


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

    }

}

