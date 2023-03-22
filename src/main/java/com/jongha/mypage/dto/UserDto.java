package com.jongha.mypage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class UserDto {
	String username;
	String email;
}
