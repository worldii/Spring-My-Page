package com.jongha.mypage.service;

import java.util.List;

import com.jongha.mypage.domain.Member;
import com.jongha.mypage.repository.MemberRepository;
import org.springframework.stereotype.Service;

import com.jongha.mypage.domain.Comment;
import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.CommentDto;
import com.jongha.mypage.repository.CommentRepository;
import com.jongha.mypage.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Comment showOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
    }

    public Long createComment(String username, Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("해당 게시물이 존재하지 않습니다."));
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));
        Comment comme = Comment.builder().post(post).content(commentDto.getContent()).member(member).createdBy(username).build();
        commentRepository.save(comme);
        return comme.getId();
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void updateComment(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        comment.updateContent(comment.getContent());
    }

    public void deleteAllComments(Long postId) {
        List<Comment> allByPostId = commentRepository.findAllByPostId(postId);
        commentRepository.deleteAll(allByPostId);
    }
}
