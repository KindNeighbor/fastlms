package com.example.fastlms.admin.repository;

import com.example.fastlms.admin.entity.Category;
import com.example.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
