package com.jongha.mypage.dto;

import com.jongha.mypage.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

	private Long id;
	private String username;
	private String password;
	private String name;


	@Builder
	public MemberDto(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public Member toEntity() {
		return Member.builder()
				.username(username)
				.password(password)
				.name(name)
				.build();

	}
}