package com.example.rbac.pojo.vo;

import com.example.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.example.rbac.pojo.example.DepartmentExample.*;

/**
 * 【部门】详情展示对象
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "【部门】详情展示对象")
public class DepartmentShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID,example = E_ID)
    private Integer id;

    @ApiModelProperty(notes = N_DEPT_NAME,example = E_DEPT_NAME)
    private String deptName;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }



}

