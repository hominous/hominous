package com.hominous.familiar.domains.member.application.dto;


import lombok.Getter;

@Getter
public class MemberSignupDto {
  private String memberId;
  private String password;
  private String passwordCheck;
  private String name;
  private String birthdate;
}
