package com.jongha.mypage.dto;

import com.jongha.mypage.domain.Comment;
import com.jongha.mypage.domain.Member;
import com.jongha.mypage.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private Member member;
    private Post post;
    private String createdBy;

    @Builder
    public CommentDto(String content, Member member, Post post, String createdBy) {
        this.content = content;
        this.post = post;
        this.member = member;
        this.createdBy = createdBy;
    }

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .post(post)
                .member(member)
                .createdBy(createdBy)
                .build();
    }
}
