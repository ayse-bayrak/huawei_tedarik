package com.huawei.controller;

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
