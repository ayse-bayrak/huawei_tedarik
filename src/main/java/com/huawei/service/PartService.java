package com.huawei.service;


import com.huawei.dto.PartDto;
import com.huawei.entity.Part;

import java.util.List;

public interface PartService {
    PartDto createPart(Long modelId, PartDto partDto);

    List<PartDto> getAllParts(Long modelId);

    void deletePart(Long partId);
}
