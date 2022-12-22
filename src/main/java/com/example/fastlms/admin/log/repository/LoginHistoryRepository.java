package com.example.fastlms.admin.log.repository;

import com.example.fastlms.admin.log.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, String> {
}
