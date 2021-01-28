
package com.example.rbac.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.example.common.pojo.dto.AbstractDTO;
import com.example.common.util.SafeUtil;
import com.example.rbac.constant.Sex;

import static com.example.rbac.pojo.example.UserExample.*;

/**
 * excel导入【用户】的数据传输对象
 *
 * @author Jack
 * @date 2020/04/25
 */
public class UserExcelDTO extends AbstractDTO {

    @ExcelProperty("123*")
    @ColumnWidth(15)
    private String ss;

    @ExcelProperty("用户名*")
    @ColumnWidth(19)
    private String username;

    @ExcelProperty("昵称*")
    @ColumnWidth(25)
    private String nickname;

    @ExcelProperty("性别*")
    @ColumnWidth(19)
    private String sex;

    @ExcelProperty("部门id*")
    @ColumnWidth(25)
    private Integer deptId;

    @ExcelProperty("角色")
    @ColumnWidth(15)
    private String roleList;


    /**
     * 创建模板示例
     *
     * @return
     */
    public static UserExcelDTO example() {
        UserExcelDTO example = new UserExcelDTO();
        example.setSs(Sex.valueToDesc(SafeUtil.getString(E_SS)));
        example.setUsername(E_USERNAME);
        example.setNickname(E_NICKNAME);
        example.setSex(Sex.valueToDesc(SafeUtil.getInteger(E_SEX)));
        example.setDeptId(SafeUtil.getInteger(E_DEPT_ID));
        return example;
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

    public String getRoleList() {
        return this.roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

}


