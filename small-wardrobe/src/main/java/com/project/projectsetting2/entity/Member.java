package com.project.projectsetting2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nickname;

    private String username;

    private String password;

    @OneToMany
    private List<Product> products;

    @OneToMany
    private List<Product> cart;

    private String role;

}
