package com.hominous.familiar.domain.member.dto;

import com.hominous.familiar.domain.crew.domain.CrewType;
import lombok.Getter;

@Getter
public class MemberCreateCrewRequest {
  private String name;
  private CrewType crewType;
}
