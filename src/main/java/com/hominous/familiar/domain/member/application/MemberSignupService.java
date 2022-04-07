package com.hominous.familiar.domain.member.application;


import com.hominous.familiar.domain.member.application.dto.MemberSignUpDto;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import com.hominous.familiar.domain.member.domain.MemberRepository;
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
  public MemberEntity save(MemberSignUpDto memberSignupDto) {

    String password = memberSignupDto.getPassword();
    String passwordCheck = memberSignupDto.getPasswordCheck();


    if (!password.equals(passwordCheck)) {
      throw new InvalidParameterException("password and passwordCheck inconsistency");
    }

    MemberEntity memberEntity = MemberEntity.builder()
        .memberId(memberSignupDto.getMemberId())
        .password(passwordEncoder.encode(memberSignupDto.getPassword()))
        .name(memberSignupDto.getName())
        .birthdate(memberSignupDto.getBirthdate())
        .build();
    return memberRepository.save(memberEntity);
  }
}