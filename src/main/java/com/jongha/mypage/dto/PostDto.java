package com.jongha.mypage.dto;

import com.jongha.mypage.domain.Member;
import com.jongha.mypage.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String createdBy;
    private Long countVisit;
    private Member member;

    @Builder
    public PostDto(String title, String description, String createdBy, Long countVisit, Member member) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.countVisit = countVisit;
        this.member = member;
    }

    public Post toEntity() {
        return Post.builder().title(title)
                .description(description)
                .countVisit(countVisit)
                .createdBy(createdBy)
                .member(member)
                .build();
    }


}
