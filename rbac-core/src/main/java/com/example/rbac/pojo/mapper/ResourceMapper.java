package com.example.rbac.pojo.mapper;

import com.example.rbac.pojo.dto.ResourceAddDTO;
import com.example.rbac.pojo.dto.ResourceUpdateDTO;
import com.example.rbac.pojo.po.ResourcePO;
import com.example.rbac.pojo.vo.ResourceShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 【资源】映射
 *
 * @author Jack
 * @date 2020/04/25
 */
@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper( ResourceMapper.class );

    /**
     * addDTO映射po
     *
     * @param resourceAddDTO
     * @return
     */
    ResourcePO fromAddDTO(ResourceAddDTO resourceAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param resourcePO
     * @param resourceUpdateDTO
     */
    void setUpdateDTO(@MappingTarget ResourcePO resourcePO, ResourceUpdateDTO resourceUpdateDTO);

    /**
     * po映射showVO
     *
     * @param resourcePO
     * @return
     */
    ResourceShowVO toShowVO(ResourcePO resourcePO);


}

