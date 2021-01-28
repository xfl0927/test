package com.example.rbac.pojo.vo;

import com.example.common.pojo.vo.AbstractVO;
import com.example.rbac.constant.ResType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.example.rbac.pojo.example.ResourceExample.*;

/**
 * 【资源】详情展示对象
 *
 * @author Jack
 * @date 2020/04/25
 */
@ApiModel(description = "【资源】详情展示对象")
public class ResourceShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID,example = E_ID)
    private Integer id;

    @ApiModelProperty(notes = N_RES_CODE,example = E_RES_CODE)
    private String resCode;

    @ApiModelProperty(notes = N_RES_NAME,example = E_RES_NAME)
    private String resName;

    @ApiModelProperty(notes = N_RES_TYPE,example = E_RES_TYPE, allowableValues = ResType.VALUES_STR)
    private Integer resType;

    @ApiModelProperty(notes = N_ORDER_NO,example = E_ORDER_NO)
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

