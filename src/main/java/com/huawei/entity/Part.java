package com.huawei.entity;

import jakarta.persistence.*;

@Entity
public class Part extends BaseEntity {
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
}
