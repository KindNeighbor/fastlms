package com.example.fastlms.member.exception;

public class MemberEmailNotAuthException extends RuntimeException {
    public MemberEmailNotAuthException(String error) {
        super(error);
    }
}
