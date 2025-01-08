package com.huawei.dto;

import java.util.List;

public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private List<Long> modelIds;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Long> getModelIds() {
        return modelIds;
    }
    public void setModelIds(List<Long> modelIds) {
        this.modelIds = modelIds;
    }
}
