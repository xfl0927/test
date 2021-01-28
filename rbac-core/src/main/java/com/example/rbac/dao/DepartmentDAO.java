package com.example.rbac.dao;

import com.example.common.dao.DAO;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.rbac.pojo.po.DepartmentPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【部门】数据库操作
 *
 * @author Jack
 * @date 2020/04/25
 */
@Repository
@Mapper
public interface DepartmentDAO extends DAO<DepartmentPO> {

    List<OptionVO<Integer, String>> findOptions(OptionQO<Integer, String> qo);


}



