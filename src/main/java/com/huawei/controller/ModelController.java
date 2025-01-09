package com.huawei.controller;

import com.huawei.dto.ModelDto;
import com.huawei.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @PostMapping
    public ResponseEntity<ModelDto> createModel(@PathVariable Long projectId, @RequestBody ModelDto modelDto) {
        return ResponseEntity.ok(modelService.createModel(projectId, modelDto));
    }

    @GetMapping
    public ResponseEntity<List<ModelDto>> getAllModels(@PathVariable Long projectId) {
        return ResponseEntity.ok(modelService.getAllModels(projectId));
    }

    @DeleteMapping("/{modelId}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long modelId) {
        modelService.deleteModel(modelId);
        return ResponseEntity.noContent().build();
    }
}
