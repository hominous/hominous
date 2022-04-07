package com.hominous.familiar.domain.auth.service;


import com.hominous.familiar.common.jwt.JwtFilter;
import com.hominous.familiar.common.jwt.TokenProvider;
import com.hominous.familiar.domain.auth.dto.SignInDto;
import com.hominous.familiar.domain.auth.dto.SignUpDto;
import com.hominous.familiar.domain.auth.dto.TokenResponse;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import com.hominous.familiar.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    @Transactional
    public MemberEntity save(SignUpDto memberSignupDto) {

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

    public ResponseEntity<TokenResponse> authorize(SignInDto signInDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signInDto.getMemberId(), signInDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer "+ jwt);

        return new ResponseEntity<>(new TokenResponse(jwt),httpHeaders, HttpStatus.OK);
    }
}
