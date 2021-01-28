package com.example.rbac.dao;

import com.example.common.dao.DAO;
import com.example.rbac.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【用户】数据库操作
 *
 * @author Jack
 * @date 2020/04/25
 */
@Repository
@Mapper
public interface UserDAO extends DAO<UserPO> {

    int getCountByDeptId(Integer deptId);

    int getCountByRole(Long roleId);

    int addRole(@Param("userId")Long userId,@Param("roleId")Long roleId);

    int removeRole(@Param("userId")Long userId,@Param("roleId")Long[] roleId);

    int removeAllRole(Long userId);


    boolean notUnique(@Param("username")String username, @Param("id")Long id);

}



