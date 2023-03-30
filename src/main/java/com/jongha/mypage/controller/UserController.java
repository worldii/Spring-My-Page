package com.jongha.mypage.controller;

import org.springframework.stereotype.Controller;

import com.jongha.mypage.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


}
