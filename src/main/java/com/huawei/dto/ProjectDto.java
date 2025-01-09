package com.huawei.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private Long id;
    private String name;
    private String managementType; // FIXED, MONTHLY, WEEKLY
    private List<ModelDto> models;
    private boolean isActive;
}
