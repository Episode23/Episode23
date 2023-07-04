package com.project.projectsetting2.dto;

import lombok.Data;

@Data
public class MemberJoinRequest {

    private String email;

    private String nickname;

    private String username;

    private String password;

    private String passwordCheck;

}
