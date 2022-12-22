package com.example.fastlms.admin.service;

import com.example.fastlms.admin.dto.BannerDto;
import com.example.fastlms.admin.model.BannerInput;
import com.example.fastlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {

    // 배너 목록
    List<BannerDto> list(BannerParam parameter);

    // 배너 상세 정보
    BannerDto getById(long id);

    // 배너 수정
    boolean set(BannerInput parameter);

    // 배너 등록
    boolean add(BannerInput parameter);

    // 프론트 배너 목록
    List<BannerDto> frontList();

    // 배너 삭제
    boolean delete(String idList);
}
