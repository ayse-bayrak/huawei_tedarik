package com.huawei.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartDto {
    private Long id;
    private String name;
    private int quantity;
    private Long modelId;
}
