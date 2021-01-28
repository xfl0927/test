package com.example.rbac.service;

import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.optimistic.OptimisticLock;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.dao.ResourceDAO;
import com.example.rbac.dao.RoleDAO;
import com.example.rbac.dao.UserDAO;
import com.example.rbac.pojo.dto.RoleAddDTO;
import com.example.rbac.pojo.dto.RoleUpdateDTO;
import com.example.rbac.pojo.mapper.RoleMapper;
import com.example.rbac.pojo.po.RolePO;
import com.example.rbac.pojo.qo.RoleQO;
import com.example.rbac.pojo.vo.RoleListVO;
import com.example.rbac.pojo.vo.RoleShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 【角色】增删改查服务
 *
 * @author Jack
 * @date 2020/04/25
 */
@Service
public class RoleService {

    @Autowired
    private ResourceDAO resourceDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;


    /**
     * 新增【角色】
     *
     * @param roleDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public RolePO save(RoleAddDTO roleDTO) {
        RolePO role = RoleMapper.INSTANCE.fromAddDTO(roleDTO);
        roleDAO.save(role);
        List<Integer> resourceList = roleDTO.getResourceList();
        if(CollectionUtils.isNotEmpty(resourceList)) {
            this.doAddResource(role.getId(), resourceList.toArray(new Integer[0]));
        }
        return role;
    }

    /**
     * 修改【角色】
     *
     * @param roleUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public RolePO update(RoleUpdateDTO roleUpdateDTO) {
        Long id = roleUpdateDTO.getId();
        RolePO role = this.getRole(id, true);
        RoleMapper.INSTANCE.setUpdateDTO(role, roleUpdateDTO);
        roleDAO.update(role);
        List<Integer> resourceList = roleUpdateDTO.getResourceList();
        if(resourceList != null) {
            this.setResource(role.getId(), resourceList.toArray(new Integer[]{}));
        }
        return role;
    }

    /**
     * 查询分页列表
     *
     * @param roleQO
     * @return
     */
    public PageVO<RoleListVO> list(RoleQO roleQO) {
        PageVO<RoleListVO> page = roleDAO.findByPage(roleQO);
        return page;
    }

    /**
     * 查询【角色】选项列表
     *
     * @return
     */
    public List<OptionVO<Long, String>> findOptions(OptionQO<Long, String> qo) {
        List<OptionVO<Long, String>> options = roleDAO.findOptions(qo);
        return options;
    }

    /**
     * 根据主键获取【角色】
     * 不获取多对多级联对象
     * @param id 主键
     * @param force 是否强制获取
     * @return
     */
    public RolePO getRole(Long id, boolean force){
        return this.getRole(id, false, force);
    }

    /**
     * 根据主键获取【角色】
     *
     * @param id 主键
     * @param withResource 是否级联获取【资源】
     * @param force 是否强制获取
     * @return
     */
    public RolePO getRole(Long id, boolean withResource, boolean force){
        RolePO role = roleDAO.findById(id);
        if (force && role == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        if (withResource){
            role.setResourcePOList(resourceDAO.findByRole(id));
        }
        return role;
    }


    /**
     * 查询【角色】详情
     *
     * @param id
     * @return
     */
    public RoleShowVO show(Long id) {
        RolePO role = this.getRole(id, true);
        RoleShowVO showVO = RoleMapper.INSTANCE.toShowVO(role);
        // 设置【资源】主键列表
        showVO.setResourceList(resourceDAO.findByRole(id)
                .stream()
                .map(t -> t.getId())
                .collect(Collectors.toList()));
        return showVO;
    }

    /**
     * 删除【角色】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Long... ids) {
        int count = 0;
        for (Long id : ids) {
            // 校验是否存在【用户】关联
            this.checkDeleteByUser(id);
            count += roleDAO.delete(id);
        }
        return count;
    }

    /**
     * 校验是否存在【用户】关联
     *
     * @param id
     */
    private void checkDeleteByUser(Long id) {
        int count = userDAO.getCountByRole(id);
        if(count>0){
            throw new BusinessException(ErrorCode.CASCADE_DELETE_ERROR);
        }
    }

    /**
     * 执行【资源】添加
     *
     * @param id
     * @param resourceId
     * @return
     */
    private int doAddResource(Long id, Integer... resourceId) {
        int count = 0;
        for (Integer _id : resourceId) {
            if(resourceDAO.exist(_id)){
                count += roleDAO.addResource(id, _id);
            }
        }
        return count;
    }

    /**
     * 设置【资源】
     *
     * @param id
     * @param resourceId
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int setResource(Long id, Integer[] resourceId) {
        RolePO role = this.getRole(id, true);
        roleDAO.removeAllResource(id);
        if(ArrayUtils.isEmpty(resourceId)){
            return 0;
        }
        return doAddResource(id, resourceId);
    }


}


