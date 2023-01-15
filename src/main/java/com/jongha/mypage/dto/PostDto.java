package com.jongha.mypage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class PostDto {
	String title;
	String description;
}
