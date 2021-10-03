package com.hominous.familiar.member.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Member {

    @Setter
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private int userYear;
    private int userMonth;
    private int userDate;
    public Member() {
    }

    public Member(MemberCreateDto memberCreateDto) {
        this.userId = memberCreateDto.getUserId();
        this.password = memberCreateDto.getPassword();
        this.userName = memberCreateDto.getUserName();
        this.userYear = memberCreateDto.getUserYear();
        this.userMonth = memberCreateDto.getUserMonth();
        this.userDate = memberCreateDto.getUserDate();
    }

}
