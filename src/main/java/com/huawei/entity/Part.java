package com.huawei.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Part extends BaseEntity {

    private String name; // Parça ismi

    private int quantity; // Modelde kullanılan parça sayısı

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model; // Parçanın bağlı olduğu model
}
