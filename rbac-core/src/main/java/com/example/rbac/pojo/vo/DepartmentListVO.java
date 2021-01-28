package com.example.rbac.pojo.vo;

import com.example.common.constant.JsonFieldConst;
import com.example.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import static com.example.rbac.pojo.example.DepartmentExample.*;

/**
 * 【部门】列表展示对象
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "【部门】列表展示对象")
public class DepartmentListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Integer id;

    @ApiModelProperty(notes = N_DEPT_NAME, example = E_DEPT_NAME)
    private String deptName;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date createdTime;


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

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }



}

