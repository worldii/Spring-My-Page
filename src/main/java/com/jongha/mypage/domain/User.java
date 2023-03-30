package com.jongha.mypage.domain;

import javax.persistence.*;

import com.jongha.mypage.dto.Role;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long id;

	@NotNull
	private String loginId;
	@NotNull
	private String password;
	@NotNull
	private String name;


	@Enumerated(EnumType.STRING)
	private Role role;

	@Builder
	public User (String loginId, String password, String name, Role role){
		this.loginId= loginId;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	public void updateName (String name) {
		this.name = name;
	}
	public void updateLoginId(String loginId) {
		this.loginId =loginId;
	}
}
