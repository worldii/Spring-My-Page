package com.jongha.mypage.domain;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String description;
    private String createdBy;
    private Long countVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateCountVisit(Long countVisit) {
        this.countVisit = countVisit;
    }

    @Builder
    public Post(String title, String description, Member member, String createdBy, Long countVisit) {
        this.title = title;
        this.description = description;
        this.member = member;
        this.createdBy = createdBy;
        this.countVisit = countVisit;
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
