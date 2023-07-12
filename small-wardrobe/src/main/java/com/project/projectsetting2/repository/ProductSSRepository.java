package com.project.projectsetting2.repository;

import com.project.projectsetting2.entity.ProductSS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSSRepository extends JpaRepository<ProductSS, Long> {
}
