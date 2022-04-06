package com.hominous.familiar.domain.member.application;


import com.hominous.familiar.domain.member.domain.MemberEntity;
import com.hominous.familiar.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class MemberFindService {

  private final MemberRepository memberRepository;

  public MemberEntity findById(Long memberIndex){
    return memberRepository.findById(memberIndex)
        .orElseThrow(
            () -> new InvalidParameterException("Member Not Exists")
        );
  }
}
