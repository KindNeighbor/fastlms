package com.example.fastlms.member.repository;

import com.example.fastlms.member.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, String> {

    Optional<List<LoginHistory>> findByUserIdOrderByLoginDtDesc(String userId);
}
