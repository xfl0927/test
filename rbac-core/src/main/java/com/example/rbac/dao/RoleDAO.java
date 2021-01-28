package com.example.rbac.dao;

import com.example.common.dao.DAO;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.rbac.pojo.po.RolePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【角色】数据库操作
 *
 * @author Jack
 * @date 2020/04/25
 */
@Repository
@Mapper
public interface RoleDAO extends DAO<RolePO> {

    List<OptionVO<Long, String>> findOptions(OptionQO<Long, String> qo);

    int getCountByResource(Integer resourceId);

    int addResource(@Param("roleId")Long roleId,@Param("resourceId")Integer resourceId);

    int removeResource(@Param("roleId")Long roleId,@Param("resourceId")Integer[] resourceId);

    int removeAllResource(Long roleId);

    List<RolePO> findByUser(Long userId);


}



