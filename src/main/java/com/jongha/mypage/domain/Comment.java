package com.jongha.mypage.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="comment_id")
	private Long id;

	@CreationTimestamp
	@Column(name="created_at")
	private LocalDateTime createdAt =LocalDateTime.now();

	private String description;

	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;

	public void updateDescription(String description){
		this.description = description;
	}

	@Builder
	public Comment(String description, Post post){
		this.description =description;
		this.post = post;
	}

}
