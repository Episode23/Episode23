package com.project.projectsetting2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    @ManyToOne
    private Member seller;

    private String name;

    private String content;

    private String type;
    
    private Integer cost;

    @OneToMany
    private List<Image> images;

    @OneToMany
    private List<ProductSS> productSSs;

    @OneToMany(mappedBy = "product")
    private List<ProductTag> tags;

}
