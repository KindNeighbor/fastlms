package com.example.fastlms.admin.service;

import com.example.fastlms.admin.dto.BannerDto;
import com.example.fastlms.admin.entity.Banner;
import com.example.fastlms.admin.mapper.BannerMapper;
import com.example.fastlms.admin.model.BannerInput;
import com.example.fastlms.admin.model.BannerParam;
import com.example.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);
        List<BannerDto> list = bannerMapper.selectList(parameter);
        if(!CollectionUtils.isEmpty(list)) {
            int i =0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;
    }

    @Override
    public BannerDto getById(long id) {
        Banner banner = bannerRepository.getById(id);
        return BannerDto.of(banner);
    }

    @Override
    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                .bannerAlterText(parameter.getBannerAlterText())
                .targetInfo(parameter.getTargetInfo())
                .linkUrl(parameter.getLinkUrl())
                .sortValue(parameter.getSortValue())
                .sortValue(parameter.getSortValue())
                .usingYn(parameter.isUsingYn())
                .regDt(LocalDateTime.now())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .build();
        bannerRepository.save(banner);
        return true;
    }

    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner =
                bannerRepository.findById(parameter.getId());
        if(!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setBannerAlterText(parameter.getBannerAlterText());
        banner.setTargetInfo(parameter.getTargetInfo());
        banner.setLinkUrl(parameter.getLinkUrl());
        banner.setSortValue(parameter.getSortValue());
        banner.setUsingYn(parameter.isUsingYn());
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public List<BannerDto> frontList() {
        List<BannerDto> bannerList = null;

        Optional<List<Banner>> optionalBanners = bannerRepository.findByUsingYnOrderBySortValue(true);

        if (optionalBanners.isPresent()) {
            List<Banner> banners = optionalBanners.get();
            bannerList = BannerDto.of(banners);
        }

        return bannerList;
    }

    @Override
    public boolean delete(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }
}
