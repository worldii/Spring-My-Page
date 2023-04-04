package com.jongha.mypage.controller;

import com.jongha.mypage.domain.Member;
import org.springframework.stereotype.Controller;

import com.jongha.mypage.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        System.out.println("dad");
        return "members/memberLoginForm";
    }

    @GetMapping("/join")
    public String addForm() {
        return "members/memberJoinForm";
    }


    @PostMapping("/join")
    public String createMember(@ModelAttribute Member member){
        memberService.join(member);
        return "members/memberSaved";
    }
}
