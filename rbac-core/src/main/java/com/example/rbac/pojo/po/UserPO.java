package com.example.rbac.pojo.po;

import com.example.common.pojo.po.AbstractPO;
import com.example.common.pojo.po.CreatedOperatedDeletedVersion;

import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UserPO extends AbstractPO implements CreatedOperatedDeletedVersion {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 12
     * @see com.example.rbac.constant.Sex
     */
    private String ss;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别 [1男,2女]
     * @see com.example.rbac.constant.Sex
     */
    private Integer sex;

    /**
     * 部门id
     */
    private Integer deptId;

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

    private List<RolePO> rolePOList;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSs() {
        return this.ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public List<RolePO> getRolePOList() {
        return this.rolePOList;
    }

    public void setRolePOList(List<RolePO> rolePOList) {
        this.rolePOList = rolePOList;
    }


}

