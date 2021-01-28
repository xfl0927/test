
package com.example.rbac.web.rest;

import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.rbac.pojo.dto.ResourceAddDTO;
import com.example.rbac.pojo.dto.ResourceUpdateDTO;
import com.example.rbac.pojo.mapper.ResourceMapper;
import com.example.rbac.pojo.po.ResourcePO;
import com.example.rbac.pojo.qo.ResourceQO;
import com.example.rbac.pojo.vo.ResourceListVO;
import com.example.rbac.pojo.vo.ResourceShowVO;
import com.example.rbac.service.ResourceService;
import com.example.rbac.web.AbstractController;
import com.example.rbac.web.api.ResourceAPI;
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
 * 【资源】控制器
 *
 * @author Jack
 * @date 2020/04/25
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/resource")
public class ResourceController extends AbstractController implements ResourceAPI {

    @Autowired
    private ResourceService resourceService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResourceShowVO> save(@Valid @RequestBody ResourceAddDTO resourceAddDTO) throws Exception {
        ResourcePO resource = resourceService.save(resourceAddDTO);
        return ResponseEntity.created(new URI(WebConst.API_PATH + "/resource/" + resource.getId()))
            .body(ResourceMapper.INSTANCE.toShowVO(resource));
    }

    @Override
    @PutMapping
    public ResponseEntity<ResourceShowVO> update(@Valid @RequestBody ResourceUpdateDTO resourceUpdateDTO) {
        ResourcePO resource = resourceService.update(resourceUpdateDTO);
        return ResponseEntity.ok(ResourceMapper.INSTANCE.toShowVO(resource));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<ResourceListVO>> list(@Valid ResourceQO resourceQO) {
        PageVO<ResourceListVO> page = resourceService.list(resourceQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/options")
    public ResponseEntity<List<OptionVO<Integer, String>>> findOptions(OptionQO<Integer, String> qo) {
        List<OptionVO<Integer, String>> options = resourceService.findOptions(qo);
        return ResponseEntity.ok(options);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResourceShowVO> show(@PathVariable Integer id) {
        ResourceShowVO resourceShowVO = resourceService.show(id);
        return ResponseEntity.ok(resourceShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        int count = resourceService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = resourceService.delete(id);
        return ResponseEntity.ok(count);
    }

}


