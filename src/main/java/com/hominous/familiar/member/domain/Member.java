package com.hominous.familiar.member.domain;

import com.hominous.familiar.dto.MemberCreateDto;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Member {
    private Long dbId;
    private String userId;
    private String password;
    private String userName;
    private int userYear;
    private int userMonth;
    private int userDate;
    public Member() {
    }

    public Member(String userId, String password, String userName, int userYear, int userMonth, int userDate) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userYear = userYear;
        this.userMonth = userMonth;
        this.userDate = userDate;
    }
}
