package com.example.rbac.pojo.dto;

import com.example.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.example.rbac.pojo.example.DepartmentExample.*;

/**
 * 修改【部门】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "修改【部门】的参数")
public class DepartmentUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID,example = E_ID,required = true)
    @NotNull
    private Integer id;

    @ApiModelProperty(notes = N_DEPT_NAME,example = E_DEPT_NAME,required = true)
    @NotNull
    @Length(max = 33)
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

