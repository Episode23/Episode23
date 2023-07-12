package com.project.projectsetting2.dto;

import lombok.Data;

@Data
public class ChangeUserInfoRequest {

    private String password;

    private String newPassword;

    private String checkPassword;

    private String newNickname;

}
