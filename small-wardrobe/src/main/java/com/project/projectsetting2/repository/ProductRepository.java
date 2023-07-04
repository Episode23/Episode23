package com.project.projectsetting2.repository;

import com.project.projectsetting2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByNameContaining(String name);

    List<Product> findAllByType(String type);

    List<Product> findAllByTypeAndNameContaining(String type, String name);

}
