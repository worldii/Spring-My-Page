package com.jongha.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jongha.mypage.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/auth/logout")
	String getLogOutPage(){
		return null;
	}

	@GetMapping("/auth/login")
	String getLoginPage(){
		return null;
	}

	@GetMapping("/auth/join")
	String getJoinPage(){
		return null;
	}

	@PostMapping("/auth/joinProc")
	String getJoinProcPage(){
		return null;
	}



}
