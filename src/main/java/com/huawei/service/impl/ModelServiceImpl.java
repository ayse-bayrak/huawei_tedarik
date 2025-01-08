package com.huawei.service.impl;

import com.huawei.entity.Model;
import com.huawei.repository.ModelRepository;
import com.huawei.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model update(Long id, Model model) {
        if (!modelRepository.existsById(id)) {
            throw new RuntimeException("Model not found with id: " + id);
        }
        model.setId(id);
        return modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        if (!modelRepository.existsById(id)) {
            throw new RuntimeException("Model not found with id: " + id);
        }
        modelRepository.deleteById(id);
    }

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found with id: " + id));
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }
}
