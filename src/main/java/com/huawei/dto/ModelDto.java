package com.huawei.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelDto {
    private Long id;
    private String name;
    private double percentage;
    private boolean active;
    private Long projectId;
    private List<PartDto> parts;
}
