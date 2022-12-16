package com.example.fastlms.admin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    private String userId;

    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;

    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;

    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;

    private boolean adminYn;
}
