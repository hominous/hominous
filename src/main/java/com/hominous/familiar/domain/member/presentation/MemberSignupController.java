package com.hominous.familiar.domain.member.presentation;


import com.hominous.familiar.domain.member.application.MemberSignupService;
import com.hominous.familiar.domain.member.application.dto.MemberSignUpDto;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberSignupController {

  private final MemberSignupService memberSignupService;

  @PostMapping("/member")
  public ResponseEntity<MemberEntity> createMember(
     @RequestBody MemberSignUpDto memberSignupDto
  ) {
    MemberEntity result = memberSignupService.save(memberSignupDto);
    return ResponseEntity.ok(result);
  }
}
