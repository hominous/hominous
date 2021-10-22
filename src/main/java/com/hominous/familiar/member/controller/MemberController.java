package com.hominous.familiar.member.controller;


import com.hominous.familiar.member.domain.LoginDto;
import com.hominous.familiar.member.domain.Member;
import com.hominous.familiar.member.dto.MemberCreateDto;
import com.hominous.familiar.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String memberForm(@PathVariable Long id, Model model) {
        Member member = memberService.findMemberById(id);
        model.addAttribute("member",member);
        return "member/welcome";
    }

    @PostMapping
    public String createMember(MemberCreateDto memberCreateDto) {
        if(passCheck(memberCreateDto)) {
            Member member = memberService.memberCreate(memberCreateDto);
            return "redirect:/members/"+member.getId();
        }
        return "member/welcomeErr";
    }

    public boolean passCheck(MemberCreateDto memberCreateDto){
        if(memberCreateDto.getPassword().equals(memberCreateDto.getPasswordCheck())) {
            return true;
        }
        return false;
    }

//    @PostMapping("/try")
//    public String loginTry(@ModelAttribute LoginDto loginDto, HttpSession httpSession) throws URISyntaxException {
//        return loginDto;
//    }

}
