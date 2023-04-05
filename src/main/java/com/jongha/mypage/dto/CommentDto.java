package com.jongha.mypage.dto;

import com.jongha.mypage.domain.Comment;
import com.jongha.mypage.domain.Member;
import com.jongha.mypage.domain.Post;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class CommentDto {
	private Long id;
	private String content;
	private Member member;
	private Post post;

	@Builder
	public CommentDto(String content, Member member, Post post) {
		this.content = content;
		this.post = post;
		this.member = member;
	}

	public Comment toEntity() {
		return Comment.builder().content(content)
				.post(post)
				.member(member)
				.build();
	}
}
