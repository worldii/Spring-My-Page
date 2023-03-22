package com.jongha.mypage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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


	private String loginId;
	private String password;
	private String name;

	@Builder
	public User (String loginId, String password, String name){
		this.loginId= loginId;
		this.password = password;
		this.name = name;
	}
}
