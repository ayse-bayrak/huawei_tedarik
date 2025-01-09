package com.huawei.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PartDto {
    private Long id;
    private String name;
    private int quantity;
    private Long modelId;
}
