package com.huawei.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@SoftDeleteable
public class Model extends BaseEntity {


    private String name;

    private double percentage; // Üretim yüzdesi

    private boolean active; // Model aktif/pasif durumu

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project; // Modelin bağlı olduğu proje

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Part> parts = new ArrayList<>();
}
