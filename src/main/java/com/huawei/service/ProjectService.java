package com.huawei.service;



import com.huawei.entity.Project;

import java.util.List;

public interface ProjectService {
    Project save(Project project);

    Project update(Long id, Project project);

    void delete(Long id);

    Project findById(Long id);

    List<Project> findAll();
}
