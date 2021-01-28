package com.example.rbac.pojo.qo;

import com.example.common.pojo.qo.PageQO;
import com.example.rbac.pojo.example.RoleExample;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import java.util.List;

import static com.example.rbac.pojo.example.UserExample.*;

/**
 * 查询【用户】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UserQO extends PageQO {

    @ApiParam(value = N_SS,example = E_SS)
    @Length(max = 32,message = "ss最大长度不能超过{max}")
    private String ss;

    @ApiParam(value = N_USERNAME,example = E_USERNAME)
    @Length(max = 32,message = "username最大长度不能超过{max}")
    private String username;

    @ApiParam(value = N_NICKNAME,example = E_NICKNAME)
    @Length(max = 32,message = "nickname最大长度不能超过{max}")
    private String nickname;

    @ApiParam(value = N_SEX)
    private List<Integer> sex;

    @ApiParam(value = N_DEPT_ID)
    private List<Integer> deptId;

    @ApiParam(value = RoleExample.N_CODE,example = RoleExample.E_CODE)
    @Length(max = 32,message = "roleCode最大长度不能超过{max}")
    private String roleCode;

    @ApiParam(value = "123排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer ssSortSign;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer operatedTimeSortSign;


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

    public List<Integer> getSex() {
        return this.sex;
    }

    public void setSex(List<Integer> sex) {
        this.sex = sex;
    }

    public List<Integer> getDeptId() {
        return this.deptId;
    }

    public void setDeptId(List<Integer> deptId) {
        this.deptId = deptId;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getSsSortSign() {
        return this.ssSortSign;
    }

    public void setSsSortSign(Integer ssSortSign) {
        this.ssSortSign = ssSortSign;
    }

    public Integer getCreatedTimeSortSign() {
        return this.createdTimeSortSign;
    }

    public void setCreatedTimeSortSign(Integer createdTimeSortSign) {
        this.createdTimeSortSign = createdTimeSortSign;
    }

    public Integer getOperatedTimeSortSign() {
        return this.operatedTimeSortSign;
    }

    public void setOperatedTimeSortSign(Integer operatedTimeSortSign) {
        this.operatedTimeSortSign = operatedTimeSortSign;
    }

}

