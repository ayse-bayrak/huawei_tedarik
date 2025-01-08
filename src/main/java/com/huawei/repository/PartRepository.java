package com.huawei.repository;

import com.huawei.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    // Özel sorgular gerekirse buraya eklenebilir
}
