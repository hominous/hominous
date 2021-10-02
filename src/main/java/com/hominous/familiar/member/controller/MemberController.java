package com.hominous.familiar.member.controller;


import com.hominous.familiar.dto.MemberCreateDto;
import com.hominous.familiar.member.domain.Member;
import com.hominous.familiar.member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new")
    public String joinForm() {
        return "member/join-form";
    }

    @PostMapping
    public String createMember(MemberCreateDto memberCreateDto, Model model) {
        Member member = new Member(
                memberCreateDto.getUserId(),
                memberCreateDto.getPassword(),
                memberCreateDto.getUserName(),
                memberCreateDto.getUserYear(),
                memberCreateDto.getUserMonth(),
                memberCreateDto.getUserDate());
        memberRepository.save(member);
        model.addAttribute("member",member);
        return "member/welcome";
    }
}
