package com.huawei.service;

import com.huawei.dto.ModelDto;

import java.util.List;

public interface ModelService {

    ModelDto createModel(Long projectId, ModelDto modelDto);

    List<ModelDto> getAllModels(Long projectId);

    void deleteModel(Long modelId);
}
