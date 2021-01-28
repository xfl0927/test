package com.example.rbac.pojo.qo;

import com.example.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import static com.example.rbac.pojo.example.RoleExample.*;

/**
 * 查询【角色】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
public class RoleQO extends PageQO {

    @ApiParam(value = N_CODE,example = E_CODE)
    @Length(max = 32,message = "code最大长度不能超过{max}")
    private String code;

    @ApiParam(value = N_ROLE_NAME,example = E_ROLE_NAME)
    @Length(max = 32,message = "roleName最大长度不能超过{max}")
    private String roleName;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer operatedTimeSortSign;


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

