package com.example.rbac.pojo.qo;

import com.example.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import static com.example.rbac.pojo.example.DepartmentExample.*;

/**
 * 查询【部门】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
public class DepartmentQO extends PageQO {

    @ApiParam(value = N_DEPT_NAME,example = E_DEPT_NAME)
    @Length(max = 33,message = "deptName最大长度不能超过{max}")
    private String deptName;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer createdTimeSortSign;


    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCreatedTimeSortSign() {
        return this.createdTimeSortSign;
    }

    public void setCreatedTimeSortSign(Integer createdTimeSortSign) {
        this.createdTimeSortSign = createdTimeSortSign;
    }

}

