package com.example.rbac.pojo.dto;

import com.example.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.example.rbac.pojo.example.RoleExample.*;

/**
 * 修改【角色】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "修改【角色】的参数")
public class RoleUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID,example = E_ID,required = true)
    @NotNull
    private Long id;

    @ApiModelProperty(notes = N_CODE,example = E_CODE,required = true)
    @NotNull
    @Length(max = 32)
    private String code;

    @ApiModelProperty(notes = N_ROLE_NAME,example = E_ROLE_NAME,required = true)
    @NotNull
    @Length(max = 32)
    private String roleName;

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

