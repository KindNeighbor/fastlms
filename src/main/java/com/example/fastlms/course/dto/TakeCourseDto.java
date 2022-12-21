package com.example.fastlms.course.dto;

import lombok.Data;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class TakeCourseDto {

    long id;
    long courseId;
    String userId;

    long payPrice;
    String status;

    LocalDateTime regDt;

    String userName;
    String phone;
    String subject;

    long totalCount;
    long seq;

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";
    }
}
