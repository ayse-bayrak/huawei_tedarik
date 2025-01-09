package com.huawei.service.impl;

import com.huawei.annotation.DefaultExceptionMessage;
import com.huawei.dto.ProjectDto;
import com.huawei.entity.Project;
import com.huawei.enums.ProjectManagementType;
import com.huawei.exception.ResourceNotFoundException;
import com.huawei.repository.ModelRepository;
import com.huawei.repository.ProjectRepository;
import com.huawei.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelRepository modelRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelRepository modelRepository) {
        this.projectRepository = projectRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id));
        return convertToDTO(project);
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDTO) {
        Project project = convertToEntity(projectDTO);
        return convertToDTO(projectRepository.save(project));
    }

    @Override
    public ProjectDto updateProject(Long id, ProjectDto projectDTO) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id));
        project.setName(projectDTO.getName());
        project.setManagementType(ProjectManagementType.valueOf(projectDTO.getManagementType()));
        project.setActive(projectDTO.isActive());
        return convertToDTO(projectRepository.save(project));
    }

    @Override
    @DefaultExceptionMessage(defaultMessage = " Failed to delete user")
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id));

        project.setIsDeleted(true);
        projectRepository.save(project);
    }

    private ProjectDto convertToDTO(Project project) {
        // Conversion logic here...
        return null;
    }

    private Project convertToEntity(ProjectDto projectDTO) {
        // Conversion logic here...
        return null;
    }
}
