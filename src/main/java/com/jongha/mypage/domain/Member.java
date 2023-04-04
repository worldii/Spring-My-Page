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
public class Member {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long id;

	@NotNull
	private String userName;
	@NotNull
	private String password;
	@NotNull
	private String name;


	@Enumerated(EnumType.STRING)
	private Role role;

	@Builder
	public Member(String userName, String password, String name, Role role){
		this.userName= userName;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	public void updateName (String name) {
		this.name = name;
	}
	public void updateUsername(String userName) {
		this.userName =userName;
	}
}
