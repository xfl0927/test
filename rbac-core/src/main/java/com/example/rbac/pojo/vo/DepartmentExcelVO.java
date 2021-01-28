package com.example.rbac.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.example.common.constant.JsonFieldConst;
import com.example.common.pojo.vo.AbstractVO;

import java.util.Date;

/**
 * 【部门】excel导出对象
 *
 * @author Jack
 * @date 2020/04/25
 */
public class DepartmentExcelVO extends AbstractVO {

    @ExcelProperty("主键ID")
    @ColumnWidth(12)
    private Integer id;

    @ExcelProperty("部门名称")
    @ColumnWidth(15)
    private String deptName;

    @ExcelProperty("创建时间")
    @DateTimeFormat(JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    @ColumnWidth(25)
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

