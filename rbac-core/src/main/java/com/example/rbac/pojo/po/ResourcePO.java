package com.example.rbac.pojo.po;

import com.example.common.pojo.po.AbstractPO;
import com.example.common.pojo.po.CreatedOperatedDeletedVersion;

import java.util.Date;

/**
 * 资源
 *
 * @author Jack
 * @date 2020/04/25
 */
public class ResourcePO extends AbstractPO implements CreatedOperatedDeletedVersion {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 资源编码
     */
    private String resCode;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 资源类型  [1菜单组,2菜单,3按钮,4请求,9其他]
     * @see com.example.rbac.constant.ResType
     */
    private Integer resType;

    /**
     * 排序号【整型】
     */
    private Integer orderNo;

    /**
     * 创建时间【yyyy-MM-dd HH:mm:ss】
     */
    private Date createdTime;

    /**
     * 创建人【最大长度20】
     */
    private String createdBy;

    /**
     * 修改时间【yyyy-MM-dd HH:mm:ss】
     */
    private Date operatedTime;

    /**
     * 修改人【最大长度20】
     */
    private String operatedBy;

    /**
     * 乐观锁版本号【整型】
     */
    private Integer version;

    /**
     * 逻辑删除标识【0-未删除，1-已删除】
     */
    private Boolean deleted;

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

    @Override
    public Date getCreatedTime() {
        return this.createdTime;
    }

    @Override
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getOperatedTime() {
        return this.operatedTime;
    }

    @Override
    public void setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
    }

    @Override
    public String getOperatedBy() {
        return this.operatedBy;
    }

    @Override
    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Boolean getDeleted() {
        return this.deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}

