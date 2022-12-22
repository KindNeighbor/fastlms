package com.example.fastlms.admin.log.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class LoginHistory {

    @Id
    String userId;

    LocalDateTime loginDt;
    String clientIp;
    String userAgent;
}
