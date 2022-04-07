package com.hominous.familiar.domain.member.domain;


import com.hominous.familiar.domain.BaseTimeEntity;
import com.hominous.familiar.domain.auth.domain.AuthorityEntity;
import com.hominous.familiar.domain.crew.domain.CrewEntity;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


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

  @ManyToMany
  @JoinTable(
          name = "member_authority",
          joinColumns = {@JoinColumn(name = "member_id",referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
  private Set<AuthorityEntity> authorityEntities;

  @Builder
  public MemberEntity(String memberId, String password, String name, String birthdate) {
    this.memberId = memberId;
    this.password = password;
    this.name = name;
    this.birthdate = birthdate;
  }
}


