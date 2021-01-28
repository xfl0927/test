
package com.example.rbac.web.rest;

import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.pojo.dto.RoleAddDTO;
import com.example.rbac.pojo.dto.RoleUpdateDTO;
import com.example.rbac.pojo.mapper.RoleMapper;
import com.example.rbac.pojo.po.RolePO;
import com.example.rbac.pojo.qo.RoleQO;
import com.example.rbac.pojo.vo.RoleListVO;
import com.example.rbac.pojo.vo.RoleShowVO;
import com.example.rbac.service.RoleService;
import com.example.rbac.web.AbstractController;
import com.example.rbac.web.api.RoleAPI;
import com.example.rbac.web.constant.WebConst;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【角色】控制器
 *
 * @author Jack
 * @date 2020/04/25
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/role")
public class RoleController extends AbstractController implements RoleAPI {

    @Autowired
    private RoleService roleService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RoleShowVO> save(@Valid @RequestBody RoleAddDTO roleAddDTO) throws Exception {
        RolePO role = roleService.save(roleAddDTO);
        return ResponseEntity.created(new URI(WebConst.API_PATH + "/role/" + role.getId()))
            .body(RoleMapper.INSTANCE.toShowVO(role));
    }

    @Override
    @PutMapping
    public ResponseEntity<RoleShowVO> update(@Valid @RequestBody RoleUpdateDTO roleUpdateDTO) {
        RolePO role = roleService.update(roleUpdateDTO);
        return ResponseEntity.ok(RoleMapper.INSTANCE.toShowVO(role));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<RoleListVO>> list(@Valid RoleQO roleQO) {
        PageVO<RoleListVO> page = roleService.list(roleQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/options")
    public ResponseEntity<List<OptionVO<Long, String>>> findOptions(OptionQO<Long, String> qo) {
        List<OptionVO<Long, String>> options = roleService.findOptions(qo);
        return ResponseEntity.ok(options);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleShowVO> show(@PathVariable Long id) {
        RoleShowVO roleShowVO = roleService.show(id);
        return ResponseEntity.ok(roleShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Long id) {
        int count = roleService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Long[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = roleService.delete(id);
        return ResponseEntity.ok(count);
    }

}


