package com.hominous.familiar.domain.auth.controller;


import com.hominous.familiar.domain.auth.dto.SignInDto;
import com.hominous.familiar.domain.auth.dto.TokenResponse;
import com.hominous.familiar.domain.auth.service.AuthService;
import com.hominous.familiar.domain.auth.dto.SignUpDto;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/auth/sign-up")
  public ResponseEntity<MemberEntity> signUp(
     @RequestBody SignUpDto signUpDto
  ) {
    MemberEntity result = authService.save(signUpDto);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/auth/sign-in")
  public ResponseEntity<TokenResponse> signIn(@Valid @RequestBody SignInDto signInDto) {
    return authService.authorize(signInDto);
  }
}
