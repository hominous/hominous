package com.hominous.familiar.domains.member.application.dto;


import lombok.Getter;

@Getter
public class MemberCreateRequest {
    private final String userId;
    private final String password;
    private final String passwordCheck;
    private final String userName;
    private final int userYear;
    private final int userMonth;
    private final int userDate;

    public MemberCreateRequest(String userId, String password, String passwordCheck, String userName, int userYear, int userMonth, int userDate) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.userName = userName;
        this.userYear = userYear;
        this.userMonth = userMonth;
        this.userDate = userDate;
    }

}
