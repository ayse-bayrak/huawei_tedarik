package com.huawei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartDto {
    private Long id;
    private String name;
    private String type;
    private Long modelId; // Related Model ID

}
