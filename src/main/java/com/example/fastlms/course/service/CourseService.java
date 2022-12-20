package com.example.fastlms.course.service;

import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.model.CourseInput;
import com.example.fastlms.course.model.CourseParam;
import com.example.fastlms.course.model.ServiceResult;
import com.example.fastlms.course.model.TakeCourseInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseService {

    // 강좌 등록
    boolean add(CourseInput parameter);

    // 강좌 수정
    boolean set(CourseInput parameter);

    // 강좌 삭제
    boolean delete(String idList);


    // 강좌 목록
    List<CourseDto> list(CourseParam parameter);

    // 강좌 상세정보
    CourseDto getById(long id);

    // 프론트 강좌 목록
    List<CourseDto> frontList(CourseParam parameter);

    // 프론트 강좌 상세 목록
    CourseDto frontDetail(long id);

    // 수강신청
    ServiceResult req(TakeCourseInput parameter);
}
