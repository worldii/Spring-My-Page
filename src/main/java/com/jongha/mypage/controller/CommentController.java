package com.jongha.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jongha.mypage.domain.Comment;
import com.jongha.mypage.dto.CommentDto;
import com.jongha.mypage.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
	private final CommentService commentService;

	@GetMapping("/comment/{postId}")
	String showPostPage(@PathVariable Long commentId , Model model){
		Comment comment = commentService.showOneComment(commentId);
		model.addAttribute("comment", comment);
		return null;
	}

	@PostMapping("/create/{postId}")
	String createCommentPage(@PathVariable Long postId, @RequestBody CommentDto commentDto){
		commentService.createComment(postId, commentDto);
		return null;
	}

	@PutMapping("/post/{postId}/comment/{commentId}")
	String updateCommentPage(@PathVariable Long commentId, CommentDto commentDto){
		commentService.updateComment(commentId, commentDto);
		return null;
	}

	@DeleteMapping("/post/{postId}/comment/{commentId}")
	String deleteCommentPage(@PathVariable Long commentId){
		commentService.deleteComment(commentId);
		return null;
	}

}
