package com.example.fastlms.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class TakeCourse implements TakeCourseCode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    long courseId;
    String userId;

    long payPrice; // 결재금액
    String status; // 상태(수강신청, 결재완료, 수강취소)

    LocalDateTime regDt; // 등록일(추가날짜)
}
