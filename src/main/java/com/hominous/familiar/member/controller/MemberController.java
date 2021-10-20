package com.hominous.familiar.member.controller;


import com.hominous.familiar.member.domain.LoginDto;
import com.hominous.familiar.member.dto.MemberCreateDto;
import com.hominous.familiar.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/new")
    public String joinForm() {
        return "member/join-form";
    }

    @GetMapping("/login")
    public String login() {return "member/login-form";}

    @GetMapping("/welcome")
    public String welcome() {return "member/welcome";}

    @PostMapping
    public String createMember(@ModelAttribute("member") MemberCreateDto memberCreateDto) {
        if(memberCreateDto.getPassword().equals(memberCreateDto.getPasswordCheck())) {
            memberService.MemberCreate(memberCreateDto);
            return "member/welcome";
        }
        return "member/welcomeErr";
    }

//    @PostMapping("/try")
//    public String loginTry(@ModelAttribute LoginDto loginDto, HttpSession httpSession) throws URISyntaxException {
//        return loginDto;
//    }

}
