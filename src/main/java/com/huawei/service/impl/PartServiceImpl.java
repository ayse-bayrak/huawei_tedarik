package com.huawei.service.impl;

import com.huawei.dto.PartDto;
import com.huawei.entity.Model;
import com.huawei.entity.Part;
import com.huawei.mapper.MapperUtil;
import com.huawei.repository.ModelRepository;
import com.huawei.repository.PartRepository;
import com.huawei.service.PartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ModelRepository modelRepository;
    private final MapperUtil mapperUtil;

    @Override
    public PartDto createPart(Long modelId, PartDto partDto) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("Model not found with id: " + modelId));

        Part part = Part.builder()
                .name(partDto.getName())
                .quantity(partDto.getQuantity())
                .model(model)
                .build();

        partRepository.save(part);
        return mapperUtil.convert(part, new PartDto());
    }

    @Override
    public List<PartDto> getAllParts(Long modelId) {
        return partRepository.findByModelId(modelId).stream()
                .map(part -> mapperUtil.convert(part, new PartDto()))
                .toList();
    }

    @Override
    public void deletePart(Long partId) {
        Part part = partRepository.findById(partId)
                .orElseThrow(() -> new EntityNotFoundException("Part not found with id: " + partId));
        partRepository.delete(part);
    }
}
