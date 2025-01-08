package com.huawei.service;

import com.huawei.entity.Model;

import java.util.List;

public interface ModelService {

    Model save(Model model);

    Model update(Long id, Model model);

    void delete(Long id);

    Model findById(Long id);

    List<Model> findAll();
}
