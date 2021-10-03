package com.hominous.familiar.member.controller;


import com.hominous.familiar.member.dto.MemberCreateDto;
import com.hominous.familiar.member.domain.Member;
import com.hominous.familiar.member.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemoryMemberRepository memoryMemberRepository;

    @Autowired
    public MemberController(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    @GetMapping("/new")
    public String joinForm() {
        return "member/join-form";
    }


    @PostMapping
    public String createMember(@ModelAttribute("member") MemberCreateDto memberCreateDto) {
        Member member = new Member(memberCreateDto);
        memoryMemberRepository.save(member);
        return "member/welcome";
    }
}
