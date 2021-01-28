package com.example.rbac.dao;

import com.example.common.dao.DAO;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.rbac.pojo.po.ResourcePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【资源】数据库操作
 *
 * @author Jack
 * @date 2020/04/25
 */
@Repository
@Mapper
public interface ResourceDAO extends DAO<ResourcePO> {

    List<OptionVO<Integer, String>> findOptions(OptionQO<Integer, String> qo);

    List<ResourcePO> findByRole(Long roleId);


}



