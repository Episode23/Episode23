package com.project.projectsetting2.dto;

import lombok.Data;

@Data
public class AddProductRequest {

    private String type;

    private String name;

    private Integer cost;

    private String tag;

    private String inventory;

    private String content;

}
