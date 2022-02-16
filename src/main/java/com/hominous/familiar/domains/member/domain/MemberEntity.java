package com.hominous.familiar.domains.member.domain;


import com.hominous.familiar.domains.BaseTimeEntity;
import com.hominous.familiar.domains.crew.domain.CrewEntity;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MemberEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String memberId;
  @NotNull
  private String password;
  @NotNull
  private String name;
  @NotNull
  private String birthdate;

  @ManyToOne
  @JoinColumn(name = "crew_id", nullable = true)
  private CrewEntity crewEntity;

  @Builder
  public MemberEntity(String memberId, String password, String name, String birthdate) {
    this.memberId = memberId;
    this.password = password;
    this.name = name;
    this.birthdate = birthdate;
  }
}


