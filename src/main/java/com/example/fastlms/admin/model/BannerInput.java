package com.example.fastlms.admin.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerInput {
    long Id;

    String bannerAlterText;
    String targetInfo;
    String linkUrl;
    int sortValue;
    boolean usingYn;
    LocalDateTime regDt;
    LocalDateTime uptDt;

    String filename;
    String urlFilename;
}
