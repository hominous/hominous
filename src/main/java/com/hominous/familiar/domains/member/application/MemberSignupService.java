package com.hominous.familiar.domains.member.application;


import com.hominous.familiar.domains.member.application.dto.MemberSignupRequest;
import com.hominous.familiar.domains.member.domain.MemberEntity;
import com.hominous.familiar.domains.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class MemberSignupService {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;


  @Transactional
  public void saveMember(MemberSignupRequest memberSignupRequest) {

    String password = memberSignupRequest.getPassword();
    String passwordCheck = memberSignupRequest.getPasswordCheck();

    if(!password.equals(passwordCheck)){
      throw new InvalidParameterException("password and passwordCheck inconsistency");
    }

    MemberEntity memberEntity = MemberEntity.builder()
        .userId(memberSignupRequest.getUserId())
        .password(passwordEncoder.encode(password))
        .userName(memberSignupRequest.getUserName())
        .userYear(memberSignupRequest.getUserYear())
        .userMonth(memberSignupRequest.getUserMonth())
        .userDate(memberSignupRequest.getUserDate())
        .build();
    memberRepository.save(memberEntity);
  }
}
