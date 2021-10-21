package com.hominous.familiar.member.service;


import com.hominous.familiar.member.domain.Member;
import com.hominous.familiar.member.dto.MemberCreateDto;
import com.hominous.familiar.member.repository.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;


    @Autowired
    public MemberService(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

    public Member memberCreate(MemberCreateDto memberCreateDto){
        Member member = new Member(memberCreateDto);
        springDataJpaMemberRepository.save(member);
        return member;
    }

    public Member findMemberById(Long id){
        Optional<Member> member = springDataJpaMemberRepository.findById(id);
        return member.get();
    }
}
