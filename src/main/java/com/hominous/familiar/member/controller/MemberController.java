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
        Member memberById = memberService.findMemberById(id);  // 변수명을 member로 해도 될것 같습니다.
        //@ModelAttribute 로 시도했으나 addAttribute가 정상적으로 되지 않음...
        model.addAttribute("member",memberById);
        return "member/welcome";
    }

    @PostMapping
    public String createMember(MemberCreateDto memberCreateDto) {
        if(memberCreateDto.getPassword().equals(memberCreateDto.getPasswordCheck())) {  // 가독성이 떨어지는것 같아 메서드로 만들면 좋을 것 같습니다. ex) if(memberCreateDto.checkPassword()) 
            Member member = memberService.memberCreate(memberCreateDto);
            return "redirect:/members/"+member.getId();
        }
        return "member/welcomeErr";
    }

//    @PostMapping("/try")
//    public String loginTry(@ModelAttribute LoginDto loginDto, HttpSession httpSession) throws URISyntaxException {
//        return loginDto;
//    }

}
