package com.hominous.familiar.member.domain;

import com.hominous.familiar.member.dto.MemberCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
