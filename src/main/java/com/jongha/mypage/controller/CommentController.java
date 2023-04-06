package com.jongha.mypage.controller;

import com.jongha.mypage.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jongha.mypage.domain.Comment;
import com.jongha.mypage.dto.CommentDto;
import com.jongha.mypage.service.CommentService;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/{postId}")
    String showPostPage(@PathVariable Long postId, Model model) {
        Comment comment = commentService.showOneComment(postId);
        model.addAttribute("comment", comment);
        return null;
    }

    @PostMapping("/comment/create/{postId}")
    public String createCommentPage(@PathVariable("postId") Long postId, @ModelAttribute CommentDto commentDto) {
        log.info("Comment : 댓글 달기 ");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        commentService.createComment(username, postId, commentDto);

        return "redirect:/post/postContent/{postId}";
    }

//	@PutMapping("/post/{postId}/comment/{commentId}")
//	String updateCommentPage(@PathVariable Long commentId, CommentDto commentDto){
//		commentService.updateComment(commentId, commentDto);
//		return null;
//	}
//
//	@DeleteMapping("/post/{postId}/comment/{commentId}")
//	String deleteCommentPage(@PathVariable Long commentId){
//		commentService.deleteComment(commentId);
//		return null;
//	}

}
