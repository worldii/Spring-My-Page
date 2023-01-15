package com.jongha.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jongha.mypage.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
