package com.huawei.service;



import com.huawei.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectById(Long id);
    ProjectDto createProject(ProjectDto projectDTO);
    ProjectDto updateProject(Long id, ProjectDto projectDTO);
    void deleteProject(Long id);
}
