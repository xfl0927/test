package com.example.rbac.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.example.common.constant.JsonFieldConst;
import com.example.common.pojo.vo.AbstractVO;

import java.util.Date;

/**
 * 【用户】excel导出对象
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UserExcelVO extends AbstractVO {

    @ExcelProperty("主键")
    @ColumnWidth(12)
    private Long id;

    @ExcelProperty("123")
    @ColumnWidth(15)
    private String ss;

    @ExcelProperty("用户名")
    @ColumnWidth(19)
    private String username;

    @ExcelProperty("昵称")
    @ColumnWidth(25)
    private String nickname;

    @ExcelProperty("性别")
    @ColumnWidth(19)
    private String sex;

    @ExcelProperty("部门id")
    @ColumnWidth(25)
    private Integer deptId;

    @ExcelProperty("创建时间")
    @DateTimeFormat(JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    @ColumnWidth(25)
    private Date createdTime;

    @ExcelProperty("修改时间")
    @DateTimeFormat(JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    @ColumnWidth(25)
    private Date operatedTime;

    @ExcelProperty("角色")
    @ColumnWidth(20)
    private String roleList;


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

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getOperatedTime() {
        return this.operatedTime;
    }

    public void setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
    }

    public String getRoleList() {
        return this.roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }


}

