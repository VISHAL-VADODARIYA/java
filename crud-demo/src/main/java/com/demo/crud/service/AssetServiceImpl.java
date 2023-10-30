package com.demo.crud.service;

import com.demo.crud.entity.Asset;
import com.demo.crud.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Asset updateAsset(Long assetId, Asset asset) {
        Asset ast = assetRepository.findById(assetId).get();
        if(Objects.nonNull(asset.getAssetName()) && !"".equalsIgnoreCase(asset.getAssetName())){
            ast.setAssetName(asset.getAssetName());
        }
        return assetRepository.save(ast);
    }

    @Override
    public void deleteAssetById(Long assetId) {
        assetRepository.deleteById(assetId);
    }

    @Override
    public Asset fetchAssetById(Long assetId) {
        return assetRepository.findById(assetId).get();
    }
}
