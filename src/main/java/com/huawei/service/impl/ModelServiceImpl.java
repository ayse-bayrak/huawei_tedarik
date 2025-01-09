package com.huawei.service.impl;

import com.huawei.annotation.DefaultExceptionMessage;
import com.huawei.dto.ModelDto;
import com.huawei.entity.Model;
import com.huawei.entity.Project;
import com.huawei.mapper.MapperUtil;
import com.huawei.repository.ModelRepository;
import com.huawei.repository.ProjectRepository;
import com.huawei.service.ModelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ProjectRepository projectRepository;
    private final MapperUtil mapperUtil;

    @Override
    public ModelDto createModel(Long projectId, ModelDto modelDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + projectId));

        Model model = Model.builder()
                .name(modelDto.getName())
                .percentage(modelDto.getPercentage())
                .active(modelDto.isActive())
                .project(project)
                .build();

        modelRepository.save(model);
        return mapperUtil.convert(model, new ModelDto());
    }

    @Override
    public List<ModelDto> getAllModels(Long projectId) {
        return modelRepository.findByProjectId(projectId).stream()
                .map(model -> mapperUtil.convert(model, new ModelDto()))
                .toList();
    }

    @Override
    @DefaultExceptionMessage(defaultMessage = " Failed to delete user")
    public void deleteModel(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("Model not found with id: " + modelId));
        model.setIsDeleted(true);
        modelRepository.save(model);
    }
}
