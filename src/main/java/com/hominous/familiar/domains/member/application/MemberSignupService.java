package com.hominous.familiar.domains.member.application;


import com.hominous.familiar.domains.member.application.dto.MemberSignupRequest;
import com.hominous.familiar.domains.member.domain.MemberEntity;
import com.hominous.familiar.domains.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignupService {
  private final MemberRepository memberRepository;

  @Transactional
  public void saveMember(MemberSignupRequest memberSignupRequest) {
    MemberEntity memberEntity = MemberEntity.builder()
        .userId(memberSignupRequest.getUserId())
        .password(memberSignupRequest.getPassword())
        .userName(memberSignupRequest.getUserName())
        .userYear(memberSignupRequest.getUserYear())
        .userMonth(memberSignupRequest.getUserMonth())
        .userDate(memberSignupRequest.getUserDate())
        .build();
    memberRepository.save(memberEntity);
  }
}
