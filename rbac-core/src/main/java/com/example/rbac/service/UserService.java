package com.example.rbac.service;

import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.optimistic.OptimisticLock;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.dao.DepartmentDAO;
import com.example.rbac.dao.RoleDAO;
import com.example.rbac.dao.UserDAO;
import com.example.rbac.pojo.dto.UserAddDTO;
import com.example.rbac.pojo.dto.UserUpdateDTO;
import com.example.rbac.pojo.mapper.RoleMapper;
import com.example.rbac.pojo.mapper.UserMapper;
import com.example.rbac.pojo.po.UserPO;
import com.example.rbac.pojo.qo.UserQO;
import com.example.rbac.pojo.vo.UserListVO;
import com.example.rbac.pojo.vo.UserShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 【用户】增删改查服务
 *
 * @author Jack
 * @date 2020/04/25
 */
@Service
public class UserService {

    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;

    /**
     * 校验数据唯一性
     * @param user
     * @param isUpdate 是否更新校验
     */
    private void checkUnique(UserPO user, boolean isUpdate){
        if(userDAO.notUnique(User.getUsername(), isUpdate?user.getId():null)){
            throw new BusinessException(ErrorCode.DUPLICATE_KEY);
        }
    }


    /**
     * 新增【用户】
     *
     * @param userDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public UserPO save(UserAddDTO userDTO) {
        UserPO user = UserMapper.INSTANCE.fromAddDTO(userDTO);
        if(user.getDeptId() != null){
            Assert.isTrue(departmentDAO.exist(user.getDeptId()),"部门id有误");
        }
        // 唯一性校验
        this.checkUnique(user,false);
        userDAO.save(user);
        List<Long> roleList = userDTO.getRoleList();
        if(CollectionUtils.isNotEmpty(roleList)) {
            this.doAddRole(user.getId(), roleList.toArray(new Long[0]));
        }
        return user;
    }

    /**
     * 批量新增【用户】
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int batchSave(List<UserAddDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (UserAddDTO addDTO : list) {
            this.save(addDTO);
        }
        return list.size();
    }

    /**
     * 修改【用户】
     *
     * @param userUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public UserPO update(UserUpdateDTO userUpdateDTO) {
        Long id = userUpdateDTO.getId();
        UserPO user = this.getUser(id, true);
        UserMapper.INSTANCE.setUpdateDTO(user, userUpdateDTO);
        if(user.getDeptId() != null){
            Assert.isTrue(departmentDAO.exist(user.getDeptId()),"部门id有误");
        }
        // 唯一性校验
        this.checkUnique(user,true);
        userDAO.update(user);
        List<Long> roleList = userUpdateDTO.getRoleList();
        if(roleList != null) {
            this.setRole(user.getId(), roleList.toArray(new Long[]{}));
        }
        return user;
    }

    /**
     * 查询分页列表
     *
     * @param userQO
     * @return
     */
    public PageVO<UserListVO> list(UserQO userQO) {
        PageVO<UserListVO> page = userDAO.findByPage(userQO);
        for(UserListVO listVO : page.getList()){
            listVO.setRoleList(RoleMapper.INSTANCE.toRoleVOForUserList(
                    roleDAO.findByUser(listVO.getId())));
        }
        return page;
    }

    /**
     * 根据主键获取【用户】
     * 不获取多对多级联对象
     * @param id 主键
     * @param force 是否强制获取
     * @return
     */
    public UserPO getUser(Long id, boolean force){
        return this.getUser(id, false, force);
    }

    /**
     * 根据主键获取【用户】
     *
     * @param id 主键
     * @param withRole 是否级联获取【角色】
     * @param force 是否强制获取
     * @return
     */
    public UserPO getUser(Long id, boolean withRole, boolean force){
        UserPO user = userDAO.findById(id);
        if (force && user == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        if (withRole){
            user.setRolePOList(roleDAO.findByUser(id));
        }
        return user;
    }


    /**
     * 查询【用户】详情
     *
     * @param id
     * @return
     */
    public UserShowVO show(Long id) {
        UserPO user = this.getUser(id, true);
        UserShowVO showVO = UserMapper.INSTANCE.toShowVO(user);
        // 设置【角色】列表
        showVO.setRoleList(RoleMapper.INSTANCE.toRoleVOForUserShow(
                roleDAO.findByUser(id)));
        return showVO;
    }

    /**
     * 删除【用户】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Long... ids) {
        int count = 0;
        for (Long id : ids) {
            count += userDAO.delete(id);
        }
        return count;
    }

    /**
     * 执行【角色】添加
     *
     * @param id
     * @param roleId
     * @return
     */
    private int doAddRole(Long id, Long... roleId) {
        int count = 0;
        for (Long _id : roleId) {
            if(roleDAO.exist(_id)){
                count += userDAO.addRole(id, _id);
            }
        }
        return count;
    }

    /**
     * 设置【角色】
     *
     * @param id
     * @param roleId
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int setRole(Long id, Long[] roleId) {
        UserPO user = this.getUser(id, true);
        userDAO.removeAllRole(id);
        if(ArrayUtils.isEmpty(roleId)){
            return 0;
        }
        return doAddRole(id, roleId);
    }


}


