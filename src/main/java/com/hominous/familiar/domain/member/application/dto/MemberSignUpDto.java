package com.hominous.familiar.domain.member.application.dto;


import lombok.Getter;

@Getter
public class MemberSignUpDto {
  private String memberId;
  private String password;
  private String passwordCheck;
  private String name;
  private String birthdate;
}
