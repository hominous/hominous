package com.hominous.familiar.domain.auth.controller;


import com.hominous.familiar.domain.auth.service.AuthService;
import com.hominous.familiar.domain.auth.dto.SignUpDto;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService memberSignupService;

  @PostMapping("/auth/sign-up")
  public ResponseEntity<MemberEntity> signUp(
     @RequestBody SignUpDto memberSignupDto
  ) {
    MemberEntity result = memberSignupService.save(memberSignupDto);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/auth/sign-in")
  public void signIn() {

  }
}
