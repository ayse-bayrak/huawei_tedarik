package com.huawei.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Part extends BaseEntity {
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

}
