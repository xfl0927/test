package com.example.rbac.help;

import com.example.common.util.SafeUtil;
import com.example.rbac.pojo.dto.*;
import com.example.rbac.pojo.po.*;
import com.example.rbac.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.rbac.pojo.example.ResourceExample.*;

@Component
public class ResourceHelper {

    @Autowired
    private ResourceService resourceService;

    /**
     * 生成add测试数据
     * @return
     */
    public ResourceAddDTO getResourceAddDTO(){
        ResourceAddDTO dto = new ResourceAddDTO();
        dto.setResCode(E_RES_CODE);
        dto.setResName(E_RES_NAME);
        dto.setResType(SafeUtil.getInteger(E_RES_TYPE));
        dto.setOrderNo(SafeUtil.getInteger(E_ORDER_NO));
        return dto;
    }


    /**
     * 生成update测试数据
     * @return
     */
    public ResourceUpdateDTO getResourceUpdateDTO(ResourcePO resource){
        ResourceUpdateDTO dto = new ResourceUpdateDTO();
        dto.setId(resource.getId());
        dto.setResCode(resource.getResCode());
        dto.setResName(resource.getResName());
        dto.setResType(resource.getResType());
        dto.setOrderNo(resource.getOrderNo());
        return dto;
    }

    /**
     * 保存示例
     * @return
     */
    public ResourcePO saveResourceExample(){
        ResourceAddDTO addDTO = this.getResourceAddDTO();
        return resourceService.save(addDTO);
    }



}

