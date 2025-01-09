package com.huawei.controller;

import com.huawei.dto.ModelDto;
import com.huawei.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @PostMapping
    @Operation(summary = "Create a new model", description = "Creates a new model for the specified project.")
    public ResponseEntity<ModelDto> createModel(@PathVariable Long projectId, @RequestBody ModelDto modelDto) {
        return ResponseEntity.ok(modelService.createModel(projectId, modelDto));
    }

    @GetMapping
    @Operation(summary = "Get all models", description = "Retrieves all models for the specified project.")
    public ResponseEntity<List<ModelDto>> getAllModels(@PathVariable Long projectId) {
        return ResponseEntity.ok(modelService.getAllModels(projectId));
    }

    @DeleteMapping("/{modelId}")
    @Operation(summary = "Delete a model", description = "Deletes a model by its ID.")
    public ResponseEntity<Void> deleteModel(@PathVariable Long modelId) {
        modelService.deleteModel(modelId);
        return ResponseEntity.noContent().build();
    }
}
