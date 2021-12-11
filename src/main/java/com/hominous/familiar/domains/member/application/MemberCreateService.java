package com.hominous.familiar.domains.member.application;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateService {
    private final MemberCreateRepository memberCreateRepository;


}
