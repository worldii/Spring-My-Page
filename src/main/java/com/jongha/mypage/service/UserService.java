package com.jongha.mypage.service;

import com.jongha.mypage.domain.User;
import org.springframework.stereotype.Service;

import com.jongha.mypage.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}
}
