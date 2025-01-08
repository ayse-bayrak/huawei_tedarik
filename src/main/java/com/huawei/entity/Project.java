package com.huawei.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Model> models;

    // Getters and Setters
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
    public List<Model> getModels() {
        return models;
    }
    public void setModels(List<Model> models) {
        this.models = models;
    }
}
