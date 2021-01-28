package com.example.rbac.service;

import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.optimistic.OptimisticLock;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.dao.DepartmentDAO;
import com.example.rbac.dao.UserDAO;
import com.example.rbac.pojo.dto.DepartmentAddDTO;
import com.example.rbac.pojo.dto.DepartmentUpdateDTO;
import com.example.rbac.pojo.mapper.DepartmentMapper;
import com.example.rbac.pojo.po.DepartmentPO;
import com.example.rbac.pojo.qo.DepartmentQO;
import com.example.rbac.pojo.vo.DepartmentListVO;
import com.example.rbac.pojo.vo.DepartmentShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【部门】增删改查服务
 *
 * @author Jack
 * @date 2020/04/25
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private UserDAO userDAO;


    /**
     * 新增【部门】
     *
     * @param departmentDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public DepartmentPO save(DepartmentAddDTO departmentDTO) {
        DepartmentPO department = DepartmentMapper.INSTANCE.fromAddDTO(departmentDTO);
        departmentDAO.save(department);
        return department;
    }

    /**
     * 批量新增【部门】
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int batchSave(List<DepartmentAddDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (DepartmentAddDTO addDTO : list) {
            this.save(addDTO);
        }
        return list.size();
    }

    /**
     * 修改【部门】
     *
     * @param departmentUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public DepartmentPO update(DepartmentUpdateDTO departmentUpdateDTO) {
        Integer id = departmentUpdateDTO.getId();
        DepartmentPO department = this.getDepartment(id, true);
        DepartmentMapper.INSTANCE.setUpdateDTO(department, departmentUpdateDTO);
        departmentDAO.update(department);
        return department;
    }

    /**
     * 查询分页列表
     *
     * @param departmentQO
     * @return
     */
    public PageVO<DepartmentListVO> list(DepartmentQO departmentQO) {
        PageVO<DepartmentListVO> page = departmentDAO.findByPage(departmentQO);
        return page;
    }

    /**
     * 查询【部门】选项列表
     *
     * @return
     */
    public List<OptionVO<Integer, String>> findOptions(OptionQO<Integer, String> qo) {
        List<OptionVO<Integer, String>> options = departmentDAO.findOptions(qo);
        return options;
    }

    /**
     * 根据主键获取【部门】
     *
     * @param id 主键
     * @param force 是否强制获取
     * @return
     */
    public DepartmentPO getDepartment(Integer id, boolean force){
        DepartmentPO department = departmentDAO.findById(id);
        if (force && department == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return department;
    }


    /**
     * 查询【部门】详情
     *
     * @param id
     * @return
     */
    public DepartmentShowVO show(Integer id) {
        DepartmentPO department = this.getDepartment(id, true);
        DepartmentShowVO showVO = DepartmentMapper.INSTANCE.toShowVO(department);
        return showVO;
    }

    /**
     * 删除【部门】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... ids) {
        int count = 0;
        for (Integer id : ids) {
            this.checkDeleteByUser(id);
            count += departmentDAO.delete(id);
        }
        return count;
    }

    /**
     * 校验是否存在【用户】关联
     *
     * @param id
     */
    private void checkDeleteByUser(Integer id) {
        int count = userDAO.getCountByDeptId(id);
        if(count>0){
            throw new BusinessException(ErrorCode.CASCADE_DELETE_ERROR);
        }
    }


}


