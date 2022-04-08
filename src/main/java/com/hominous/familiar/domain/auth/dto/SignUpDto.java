package com.hominous.familiar.domain.auth.dto;


import lombok.Getter;

@Getter
public class SignUpDto {
  private String memberId;
  private String password;
  private String passwordCheck;
  private String name;
  private String birthdate;
}
