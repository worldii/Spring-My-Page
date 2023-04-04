package com.jongha.mypage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jongha.mypage.domain.Comment;
import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.CommentDto;
import com.jongha.mypage.repository.CommentRepository;
import com.jongha.mypage.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public Comment showOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
    }

    public Long createComment(Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
        Comment comme = Comment.builder().post(post).description(commentDto.getDescription()).build();
        return comme.getId();
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void updateComment(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        comment.updateDescription(comment.getDescription());
    }

    public void deleteAllComments(Long postId) {
        List<Comment> allByPostId = commentRepository.findAllByPostId(postId);
        commentRepository.deleteAll(allByPostId);
    }
}
