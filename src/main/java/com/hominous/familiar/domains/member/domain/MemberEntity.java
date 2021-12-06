package com.hominous.familiar.domains.member.domain;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String userId;
  @NotNull
  private String password;
  @NotNull
  private String userName;
  @NotNull
  private int userYear;
  @NotNull
  private int userMonth;
  @NotNull
  private int userDate;

  @Builder
  public MemberEntity(String userId, String password, String userName, int userYear, int userMonth, int userDate) {
    this.userId = userId;
    this.password = password;
    this.userName = userName;
    this.userYear = userYear;
    this.userMonth = userMonth;
    this.userDate = userDate;
  }
}
