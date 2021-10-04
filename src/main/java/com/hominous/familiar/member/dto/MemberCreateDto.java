package com.hominous.familiar.member.dto;


import lombok.Getter;

@Getter
public class MemberCreateDto {
    private final String userId;
    private final String password;
    private final String userName;
    private final int userYear;
    private final int userMonth;
    private final int userDate;

    public MemberCreateDto(String userId, String password, String userName, int userYear, int userMonth, int userDate) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userYear = userYear;
        this.userMonth = userMonth;
        this.userDate = userDate;
    }
}
