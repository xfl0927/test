package com.example.rbac.pojo.dto;

import com.example.common.pojo.dto.AbstractDTO;
import com.example.common.validator.Const;
import com.example.rbac.constant.ResType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.example.rbac.pojo.example.ResourceExample.*;

/**
 * 修改【资源】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "修改【资源】的参数")
public class ResourceUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID,example = E_ID,required = true)
    @NotNull
    private Integer id;

    @ApiModelProperty(notes = N_RES_CODE,example = E_RES_CODE,required = true)
    @NotNull
    @Length(max = 32)
    private String resCode;

    @ApiModelProperty(notes = N_RES_NAME,example = E_RES_NAME,required = true)
    @NotNull
    @Length(max = 32)
    private String resName;

    @ApiModelProperty(notes = N_RES_TYPE,example = E_RES_TYPE,required = true, allowableValues = ResType.VALUES_STR)
    @NotNull
    @Const(constClass = ResType.class)
    private Integer resType;

    @ApiModelProperty(notes = N_ORDER_NO,example = E_ORDER_NO,required = true)
    @NotNull
    private Integer orderNo;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResCode() {
        return this.resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResName() {
        return this.resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Integer getResType() {
        return this.resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public Integer getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }


}

