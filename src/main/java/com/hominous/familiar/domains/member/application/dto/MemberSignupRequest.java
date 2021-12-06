package com.hominous.familiar.domains.member.application.dto;


import lombok.Getter;

@Getter
public class MemberSignupRequest {
  private String userId;
  private String password;
  private String userName;
  private int userYear;
  private int userMonth;
  private int userDate;
}
