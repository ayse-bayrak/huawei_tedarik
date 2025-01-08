package com.huawei.repository;

import com.huawei.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    // Özel sorgular gerekirse buraya eklenebilir
}
