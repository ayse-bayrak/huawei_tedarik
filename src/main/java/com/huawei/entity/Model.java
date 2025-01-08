package com.huawei.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Model extends BaseEntity {
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Part> parts;

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
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public List<Part> getParts() {
        return parts;
    }
    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
