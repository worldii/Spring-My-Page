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


	private String userName;
	private String nickName;
	private String email;

	@Builder
	public User (String userName, String email, String nickName){
		this.userName= userName;
		this.nickName = nickName;
		this.email = email;
	}
}
