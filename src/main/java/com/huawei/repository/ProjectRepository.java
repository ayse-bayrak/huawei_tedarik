package com.huawei.repository;

import com.huawei.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Özel sorgular gerekirse buraya eklenebilir
}
