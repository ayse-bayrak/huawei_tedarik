package com.huawei.controller;

import com.huawei.dto.PartDto;
import com.huawei.service.PartService;
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
    public ResponseEntity<PartDto> createPart(@PathVariable Long modelId, @RequestBody PartDto partDto) {
        return ResponseEntity.ok(partService.createPart(modelId, partDto));
    }

    @GetMapping
    public ResponseEntity<List<PartDto>> getAllParts(@PathVariable Long modelId) {
        return ResponseEntity.ok(partService.findAll(modelId));
    }

    @DeleteMapping("/{partId}")
    public ResponseEntity<Void> deletePart(@PathVariable Long partId) {
        partService.delete(partId);
        return ResponseEntity.noContent().build();
    }
}
