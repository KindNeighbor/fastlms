package com.example.fastlms.course.service;

import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.dto.TakeCourseDto;
import com.example.fastlms.course.model.*;

import java.util.List;

public interface TakeCourseService {

    // 수강 목록
    List<TakeCourseDto> list(TakeCourseParam parameter);

    // 수강내용 상태 변경
    ServiceResult updateStatus(long id, String status);

}
