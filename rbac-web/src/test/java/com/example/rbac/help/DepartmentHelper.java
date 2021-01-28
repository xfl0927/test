package com.example.rbac.help;

import com.example.rbac.pojo.dto.*;
import com.example.rbac.pojo.po.*;
import com.example.rbac.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.rbac.pojo.example.DepartmentExample.*;

@Component
public class DepartmentHelper {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 生成add测试数据
     * @return
     */
    public DepartmentAddDTO getDepartmentAddDTO(){
        DepartmentAddDTO dto = new DepartmentAddDTO();
        dto.setDeptName(E_DEPT_NAME);
        return dto;
    }


    /**
     * 生成update测试数据
     * @return
     */
    public DepartmentUpdateDTO getDepartmentUpdateDTO(DepartmentPO department){
        DepartmentUpdateDTO dto = new DepartmentUpdateDTO();
        dto.setId(department.getId());
        dto.setDeptName(department.getDeptName());
        return dto;
    }

    /**
     * 保存示例
     * @return
     */
    public DepartmentPO saveDepartmentExample(){
        DepartmentAddDTO addDTO = this.getDepartmentAddDTO();
        return departmentService.save(addDTO);
    }



}

