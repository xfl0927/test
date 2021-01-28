
package com.example.rbac.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.example.common.pojo.dto.AbstractDTO;

import static com.example.rbac.pojo.example.DepartmentExample.*;

/**
 * excel导入【部门】的数据传输对象
 *
 * @author Jack
 * @date 2020/04/25
 */
public class DepartmentExcelDTO extends AbstractDTO {

    @ExcelProperty("部门名称*")
    @ColumnWidth(15)
    private String deptName;


    /**
     * 创建模板示例
     *
     * @return
     */
    public static DepartmentExcelDTO example() {
        DepartmentExcelDTO example = new DepartmentExcelDTO();
        example.setDeptName(E_DEPT_NAME);
        return example;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}


