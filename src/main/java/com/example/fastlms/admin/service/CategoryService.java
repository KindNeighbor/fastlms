package com.example.fastlms.admin.service;

import com.example.fastlms.admin.dto.CategoryDto;
import com.example.fastlms.admin.entity.Category;
import com.example.fastlms.admin.model.CategoryInput;
import com.example.fastlms.course.model.CourseParam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> list();
    // 카테고리 신규 추가
    boolean add(String categoryName);

    // 카테고리 수정
    boolean update(CategoryInput parameter);

    // 카테고리 삭제
    boolean delete(long id);

    // 프런트 카테고리 정보
    List<CategoryDto> frontList(CategoryDto parameter);
}
