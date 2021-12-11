package com.hominous.familiar.domains.member.domain;


import com.hominous.familiar.member.dto.MemberCreateDto;
import lombok.Builder;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String userName;
    private int userYear;
    private int userMonth;
    private int userDate;

    @Builder
    public Member(MemberCreateDto memberCreateDto) {
        this.userId = memberCreateDto.getUserId();
        this.password = memberCreateDto.getPassword();
        this.userName = memberCreateDto.getUserName();
        this.userYear = memberCreateDto.getUserYear();
        this.userMonth = memberCreateDto.getUserMonth();
        this.userDate = memberCreateDto.getUserDate();
    }

}
