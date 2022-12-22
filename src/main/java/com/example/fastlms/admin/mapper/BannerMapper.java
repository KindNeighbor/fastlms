package com.example.fastlms.admin.mapper;

import com.example.fastlms.admin.dto.BannerDto;
import com.example.fastlms.admin.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);
}
