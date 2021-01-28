package com.example.rbac.pojo.po;

import com.example.common.pojo.po.AbstractPO;
import com.example.common.pojo.po.Created;
import com.example.common.pojo.po.Deleted;
import com.example.common.pojo.po.OperatedBy;
import com.example.common.pojo.po.Version;

import java.util.Date;

/**
 * 部门
 * <p>部门
 *
 * @author Jack
 * @date 2020/04/25
 */
public class DepartmentPO extends AbstractPO implements Created, OperatedBy, Deleted, Version {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 创建时间【yyyy-MM-dd HH:mm:ss】
     */
    private Date createdTime;

    /**
     * 创建人【最大长度20】
     */
    private String createdBy;

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

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

