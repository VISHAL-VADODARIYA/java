package com.demo.crud.controller;

import com.demo.crud.dto.AssetDTO;
import com.demo.crud.dto.DepartmentDTO;
import com.demo.crud.entity.Asset;
import com.demo.crud.entity.Department;
import com.demo.crud.mapper.MapstructMapperAsset;
import com.demo.crud.service.AssetService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssetController {

    @Autowired
    private AssetService assetService;

    MapstructMapperAsset mapper = Mappers.getMapper(MapstructMapperAsset.class);

    @PostMapping("/asset")
    public AssetDTO saveAsset(@RequestBody AssetDTO asset){
        Asset save = mapper.dtoToEntity(asset);
        Asset saveAsset = assetService.saveAsset(save);
        return mapper.entityToDto(saveAsset);
    }

    @GetMapping("/asset/{id}")
    public AssetDTO fetchAssetById(@PathVariable("id") Long assetId) {

        Asset fetchAssetById = assetService.fetchAssetById(assetId);
        return mapper.entityToDto(fetchAssetById);

    }

    @PutMapping("/asset/{id}")
    public AssetDTO updateAsset(@PathVariable("id") Long assetId,@RequestBody AssetDTO asset){
        Asset update = mapper.dtoToEntity(asset);
        Asset updateAsset = assetService.updateAsset(assetId , update);
        return mapper.entityToDto(updateAsset);
    }

    @DeleteMapping("/asset/{id}")
    public String deleteAssetById(@PathVariable("id") Long assetId){
        assetService.deleteAssetById(assetId);
        return "Asset Deleted Successfully!";
    }
}
