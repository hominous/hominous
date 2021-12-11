package com.hominous.familiar.domains.member.application;


import com.hominous.familiar.domains.member.application.dto.MemberCreateRequest;
import com.hominous.familiar.domains.member.domain.MemberEntity;
import com.hominous.familiar.domains.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateService {
    private final MemberRepository memberRepository;

    public void createMember(MemberCreateRequest memberCreateRequest){
        MemberEntity memberEntity = MemberEntity.builder()
                .userId(memberCreateRequest.getUserId())
                .password(memberCreateRequest.getPassword())
                .userName(memberCreateRequest.getUserName())
                .userYear(memberCreateRequest.getUserYear())
                .userMonth(memberCreateRequest.getUserMonth())
                .userDate(memberCreateRequest.getUserDate())
                .build();
        memberRepository.save(memberEntity);
    }

}
