package com.example.rbac.help;

import com.example.common.util.SafeUtil;
import com.example.rbac.pojo.dto.*;
import com.example.rbac.pojo.po.*;
import com.example.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.rbac.pojo.example.UserExample.*;

@Component
public class UserHelper {

    @Autowired
    private UserService userService;

    /**
     * 生成add测试数据
     * @return
     */
    public UserAddDTO getUserAddDTO(Integer deptId){
        UserAddDTO dto = new UserAddDTO();
        dto.setSs(E_SS);
        dto.setUsername(E_USERNAME);
        dto.setNickname(E_NICKNAME);
        dto.setSex(SafeUtil.getInteger(E_SEX));
        dto.setDeptId(deptId);
        return dto;
    }


    /**
     * 生成update测试数据
     * @return
     */
    public UserUpdateDTO getUserUpdateDTO(UserPO user){
        UserUpdateDTO dto = new UserUpdateDTO();
        dto.setId(user.getId());
        dto.setSs(user.getSs());
        dto.setNickname(user.getNickname());
        dto.setSex(user.getSex());
        dto.setDeptId(user.getDeptId());
        return dto;
    }

    /**
     * 保存示例
     * @return
     */
    public UserPO saveUserExample(Integer deptId){
        UserAddDTO addDTO = this.getUserAddDTO(deptId);
        return userService.save(addDTO);
    }



}

