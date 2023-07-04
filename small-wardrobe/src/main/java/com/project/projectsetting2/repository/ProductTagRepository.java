package com.project.projectsetting2.repository;

import com.project.projectsetting2.entity.ProductTag;
import com.project.projectsetting2.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Long> {

    List<ProductTag> findAllByTag(Tag tag);

}
