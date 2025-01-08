package com.huawei.dto;

import java.util.List;

public class ModelDto {
    private Long id;
    private String name;
    private String description;
    private Long projectId; // Related Project ID
    private List<Long> partIds;

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
    public Long getProjectId() {
        return projectId;
    }
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public List<Long> getPartIds() {
        return partIds;
    }
    public void setPartIds(List<Long> partIds) {
        this.partIds = partIds;
    }
}
