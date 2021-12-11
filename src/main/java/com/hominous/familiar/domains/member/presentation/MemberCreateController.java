package com.hominous.familiar.domains.member.presentation;


import com.hominous.familiar.domains.member.application.dto.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberCreateController {

    private final MemberCreateService memberCreateService;

    public ResponseEntity createMember (MemberCreateRequest memberCreateRequest){
        memberCreateService
    }
}
