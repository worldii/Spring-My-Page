package com.jongha.mypage.dto;

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


    @Builder
    public PostDto(String title, String description, String createdBy, Long countVisit) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.countVisit = countVisit;
    }

    public Post toEntity() {
        return Post.builder().title(title)
                .description(description)
                .countVisit(countVisit)
                .createdBy(createdBy)
                .build();
    }


}
