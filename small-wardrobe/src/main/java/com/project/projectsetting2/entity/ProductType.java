package com.project.projectsetting2.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {

    CLOTHES("CLOTHES"),

    ACCESSORY("ACCESSORY"),

    ETC("ETC");

    private final String key;

}
