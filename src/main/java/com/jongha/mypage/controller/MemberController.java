package com.jongha.mypage.controller;

import com.jongha.mypage.domain.Member;
import com.jongha.mypage.dto.MemberDto;
import org.springframework.stereotype.Controller;

import com.jongha.mypage.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "members/memberLoginForm";
    }

    @GetMapping("/join")
    public String addForm() {
        return "members/memberJoinForm";
    }


    @PostMapping("/join")
    public String createMember(@ModelAttribute MemberDto member){
        memberService.joinUser(member);
        return "redirect:/";
    }

    @GetMapping("/loginResult")
    public String loginResult() {
        return "members/memberLoginResult";
    }


    @GetMapping("/memberList")
    public  String findAllMember(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("members",memberList);
        return  "members/memberList";
    }
}
