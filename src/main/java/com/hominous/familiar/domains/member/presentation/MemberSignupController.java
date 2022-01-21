package com.hominous.familiar.domains.member.presentation;


import com.hominous.familiar.domains.member.application.MemberSignupService;
import com.hominous.familiar.domains.member.application.dto.MemberSignupDto;
import com.hominous.familiar.domains.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberSignupController {

  private final MemberSignupService memberSignupService;

  @PostMapping("/member")
  public ResponseEntity<MemberEntity> createMember(MemberSignupDto memberSignupDto) {
    MemberEntity result = memberSignupService.save(memberSignupDto);
    return ResponseEntity.ok(result);
  }
}
