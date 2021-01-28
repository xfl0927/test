package com.example.rbac.pojo.mapper;

import com.example.rbac.pojo.dto.RoleAddDTO;
import com.example.rbac.pojo.dto.RoleUpdateDTO;
import com.example.rbac.pojo.po.RolePO;
import com.example.rbac.pojo.vo.RoleShowVO;
import com.example.rbac.pojo.vo.UserListVO;
import com.example.rbac.pojo.vo.UserShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 【角色】映射
 *
 * @author Jack
 * @date 2020/04/25
 */
@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper( RoleMapper.class );

    /**
     * addDTO映射po
     *
     * @param roleAddDTO
     * @return
     */
    RolePO fromAddDTO(RoleAddDTO roleAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param rolePO
     * @param roleUpdateDTO
     */
    void setUpdateDTO(@MappingTarget RolePO rolePO, RoleUpdateDTO roleUpdateDTO);

    /**
     * po映射showVO
     *
     * @param rolePO
     * @return
     */
    RoleShowVO toShowVO(RolePO rolePO);


    List<UserListVO.RoleVO> toRoleVOForUserList(List<RolePO> list);

    List<UserShowVO.RoleVO> toRoleVOForUserShow(List<RolePO> list);

}

