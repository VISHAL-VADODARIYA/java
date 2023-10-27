package com.demo.crud.mapper;

import com.demo.crud.dto.AssetDTO;
import com.demo.crud.entity.Asset;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapstructMapperAsset {

    Asset dtoToEntity(AssetDTO dto);
    List<Asset> dtoToEntityList(List<AssetDTO> dto);
    AssetDTO entityToDto(Asset asset);
    List<AssetDTO> entityToDtoList(List<Asset> asset);
}
