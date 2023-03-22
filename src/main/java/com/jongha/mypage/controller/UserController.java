package com.jongha.mypage.controller;

import com.jongha.mypage.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jongha.mypage.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/")
    String getHomePage() {
        return "home";
    }

    @GetMapping("/members/add")
    String getMemberPage(@ModelAttribute User user) {
        return "members/addMemberForm";
    }

    @PostMapping("/members/add")
    String saveMember(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "members/addMemberForm";
        }
		userService.save(user);
		return "redirect:/";
    }

    @GetMapping("/auth/logout")
    String getLogOutPage() {
        return null;
    }

    @GetMapping("/auth/login")
    String getLoginPage() {
        return "home";
    }

    @PostMapping("/auth/login")
    String postLoginPage() {
        return "home";
    }

    @GetMapping("/auth/join")
    String getJoinPage() {
        return null;
    }

    @PostMapping("/auth/joinProc")
    String getJoinProcPage() {
        return null;
    }


}
