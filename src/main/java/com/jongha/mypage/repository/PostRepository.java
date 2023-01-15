package com.jongha.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jongha.mypage.domain.Post;

@Repository
public interface PostRepository extends JpaRepository <Post,Long> {
}
