package com.example.rbac.pojo.qo;

import com.example.common.pojo.qo.PageQO;
import com.example.rbac.pojo.example.RoleExample;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import static com.example.rbac.pojo.example.ResourceExample.*;

/**
 * 查询【资源】的参数
 *
 * @author Jack
 * @date 2020/04/25
 */
public class ResourceQO extends PageQO {

    @ApiParam(value = N_RES_CODE,example = E_RES_CODE)
    @Length(max = 32,message = "resCode最大长度不能超过{max}")
    private String resCode;

    @ApiParam(value = N_RES_NAME,example = E_RES_NAME)
    @Length(max = 32,message = "resName最大长度不能超过{max}")
    private String resName;

    @ApiParam(value = N_RES_TYPE,example = E_RES_TYPE)
    private Integer resType;

    @ApiParam(value = RoleExample.N_CODE,example = RoleExample.E_CODE)
    @Length(max = 32,message = "code最大长度不能超过{max}")
    private String code;

    @ApiParam(value = "排序号排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer orderNoSortSign;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】",example = "1")
    private Integer operatedTimeSortSign;


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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOrderNoSortSign() {
        return this.orderNoSortSign;
    }

    public void setOrderNoSortSign(Integer orderNoSortSign) {
        this.orderNoSortSign = orderNoSortSign;
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

