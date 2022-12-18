package com.example.fastlms.course.service;

import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.model.CourseInput;
import com.example.fastlms.course.model.CourseParam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseService {

    // 강좌 등록
    boolean add(CourseInput parameter);

    // 강좌 목록
    List<CourseDto> list(CourseParam parameter);
}
