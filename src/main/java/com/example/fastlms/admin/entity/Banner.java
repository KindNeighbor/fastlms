package com.example.fastlms.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bannerAlterText;
    String targetInfo;
    String linkUrl;
    int sortValue;
    boolean usingYn;
    LocalDateTime regDt;

    String filename;
    String urlFilename;
}
