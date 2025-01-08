package com.huawei.service.impl;

import com.huawei.entity.Part;
import com.huawei.repository.PartRepository;
import com.huawei.service.PartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Part save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public Part update(Long id, Part part) {
        if (!partRepository.existsById(id)) {
            throw new RuntimeException("Part not found with id: " + id);
        }
        part.setId(id);
        return partRepository.save(part);
    }

    @Override
    public void delete(Long id) {
        if (!partRepository.existsById(id)) {
            throw new RuntimeException("Part not found with id: " + id);
        }
        partRepository.deleteById(id);
    }

    @Override
    public Part findById(Long id) {
        return partRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Part not found with id: " + id));
    }

    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }
}
