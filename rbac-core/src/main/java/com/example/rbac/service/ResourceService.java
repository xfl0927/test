package com.example.rbac.service;

import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.optimistic.OptimisticLock;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.dao.ResourceDAO;
import com.example.rbac.dao.RoleDAO;
import com.example.rbac.pojo.dto.ResourceAddDTO;
import com.example.rbac.pojo.dto.ResourceUpdateDTO;
import com.example.rbac.pojo.mapper.ResourceMapper;
import com.example.rbac.pojo.po.ResourcePO;
import com.example.rbac.pojo.qo.ResourceQO;
import com.example.rbac.pojo.vo.ResourceListVO;
import com.example.rbac.pojo.vo.ResourceShowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【资源】增删改查服务
 *
 * @author Jack
 * @date 2020/04/25
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceDAO resourceDAO;
    @Autowired
    private RoleDAO roleDAO;


    /**
     * 新增【资源】
     *
     * @param resourceDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public ResourcePO save(ResourceAddDTO resourceDTO) {
        ResourcePO resource = ResourceMapper.INSTANCE.fromAddDTO(resourceDTO);
        resourceDAO.save(resource);
        return resource;
    }

    /**
     * 修改【资源】
     *
     * @param resourceUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public ResourcePO update(ResourceUpdateDTO resourceUpdateDTO) {
        Integer id = resourceUpdateDTO.getId();
        ResourcePO resource = this.getResource(id, true);
        ResourceMapper.INSTANCE.setUpdateDTO(resource, resourceUpdateDTO);
        resourceDAO.update(resource);
        return resource;
    }

    /**
     * 查询分页列表
     *
     * @param resourceQO
     * @return
     */
    public PageVO<ResourceListVO> list(ResourceQO resourceQO) {
        PageVO<ResourceListVO> page = resourceDAO.findByPage(resourceQO);
        return page;
    }

    /**
     * 查询【资源】选项列表
     *
     * @return
     */
    public List<OptionVO<Integer, String>> findOptions(OptionQO<Integer, String> qo) {
        List<OptionVO<Integer, String>> options = resourceDAO.findOptions(qo);
        return options;
    }

    /**
     * 根据主键获取【资源】
     *
     * @param id 主键
     * @param force 是否强制获取
     * @return
     */
    public ResourcePO getResource(Integer id, boolean force){
        ResourcePO resource = resourceDAO.findById(id);
        if (force && resource == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return resource;
    }


    /**
     * 查询【资源】详情
     *
     * @param id
     * @return
     */
    public ResourceShowVO show(Integer id) {
        ResourcePO resource = this.getResource(id, true);
        ResourceShowVO showVO = ResourceMapper.INSTANCE.toShowVO(resource);
        return showVO;
    }

    /**
     * 删除【资源】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... ids) {
        int count = 0;
        for (Integer id : ids) {
            // 校验是否存在【角色】关联
            this.checkDeleteByRole(id);
            count += resourceDAO.delete(id);
        }
        return count;
    }

    /**
     * 校验是否存在【角色】关联
     *
     * @param id
     */
    private void checkDeleteByRole(Integer id) {
        int count = roleDAO.getCountByResource(id);
        if(count>0){
            throw new BusinessException(ErrorCode.CASCADE_DELETE_ERROR);
        }
    }


}


