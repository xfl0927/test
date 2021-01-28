package com.example.rbac.pojo.mapper;

import com.example.rbac.pojo.dto.UserAddDTO;
import com.example.rbac.pojo.dto.UserExcelDTO;
import com.example.rbac.pojo.dto.UserUpdateDTO;
import com.example.rbac.pojo.po.UserPO;
import com.example.rbac.pojo.vo.UserExcelVO;
import com.example.rbac.pojo.vo.UserListVO;
import com.example.rbac.pojo.vo.UserShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 【用户】映射
 *
 * @author Jack
 * @date 2020/04/25
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    /**
     * addDTO映射po
     *
     * @param userAddDTO
     * @return
     */
    UserPO fromAddDTO(UserAddDTO userAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param userPO
     * @param userUpdateDTO
     */
    void setUpdateDTO(@MappingTarget UserPO userPO, UserUpdateDTO userUpdateDTO);

    /**
     * po映射showVO
     *
     * @param userPO
     * @return
     */
    UserShowVO toShowVO(UserPO userPO);


    /**
     * excelDTO映射addDTO
     *
     * @param dto
     * @return
     */
    @Mappings({
            @Mapping(target = "ss", expression = "java(com.example.rbac.constant.Sex.descToValue(dto.getSs()))"),
            @Mapping(target = "sex", expression = "java(com.example.rbac.constant.Sex.descToValue(dto.getSex()))"),
            @Mapping(target = "roleList", expression = "java(com.example.common.util.ConvertUtil.convertLongList(dto.getRoleList()))"),
    })
    UserAddDTO fromExcelDTO(UserExcelDTO dto);

    /**
     * listVO列表转excelVO列表
     *
     * @param list
     * @return
     */
    List<UserExcelVO> toExcelVOList(List<UserListVO> list);

    /**
     * listVO转excelVO
     *
     * @param vo
     * @return
     */
    @Mappings({
            @Mapping(target = "ss", expression = "java(com.example.rbac.constant.Sex.valueToDesc(vo.getSs()))"),
            @Mapping(target = "sex", expression = "java(com.example.rbac.constant.Sex.valueToDesc(vo.getSex()))"),
    })
    UserExcelVO toExcelVO(UserListVO vo);

    /**
     * 角色列表转字符串逗号分隔
     *
     * @param list
     * @return
     */
    default String convertRoleList(List<UserListVO.RoleVO> list) {
        String result = "";
        if (CollectionUtils.isNotEmpty(list)) {
            result = list.stream()
                    .map(UserListVO.RoleVO::getRoleName)
                    .collect(Collectors.joining(","));
        }
        return result;
    }

}

