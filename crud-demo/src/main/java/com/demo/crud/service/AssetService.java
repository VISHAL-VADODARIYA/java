package com.demo.crud.service;

import com.demo.crud.dto.AssetDTO;
import com.demo.crud.entity.Asset;

public interface AssetService {
    public Asset saveAsset(Asset asset);

    public Asset updateAsset(Long assetId ,Asset asset);

    public void deleteAssetById(Long assetId);

    public Asset fetchAssetById(Long assetId);
}
