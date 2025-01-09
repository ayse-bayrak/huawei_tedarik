package com.huawei.controller;

import com.huawei.dto.PartDto;
import com.huawei.service.PartService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models/{modelId}/parts")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @PostMapping
    @Operation(summary = "Create a new part", description = "Creates a new part for the specified model.")
    public ResponseEntity<PartDto> createPart(@PathVariable Long modelId, @RequestBody PartDto partDto) {
        return ResponseEntity.ok(partService.createPart(modelId, partDto));
    }

    @GetMapping
    @Operation(summary = "Get all parts", description = "Retrieves all parts for the specified model.")
    public ResponseEntity<List<PartDto>> getAllParts(@PathVariable Long modelId) {
        return ResponseEntity.ok(partService.getAllParts(modelId));
    }

    @DeleteMapping("/{partId}")
    @Operation(summary = "Delete a part", description = "Deletes a part by its ID.")
    public ResponseEntity<Void> deletePart(@PathVariable Long partId) {
        partService.deletePart(partId);
        return ResponseEntity.noContent().build();
    }
}
