package com.huawei.service;


import com.huawei.entity.Part;

import java.util.List;

public interface PartService {
    Part save(Part part);

    Part update(Long id, Part part);

    void delete(Long id);

    Part findById(Long id);

    List<Part> findAll();
}
