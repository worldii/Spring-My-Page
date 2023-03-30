package com.jongha.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.PostDto;
import com.jongha.mypage.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@GetMapping("/post/{postId}")
	String showPostPage(@PathVariable Long postId , Model model){
		Post post = postService.showOnePost(postId);
		model.addAttribute("post", post);
		return null;
	}

	@PostMapping("/post/write")
	String createPostPage( @RequestBody PostDto postDto){
		Long postId = postService.createPost(postDto);
		return null;
	}

	@PutMapping("/post/{postId}")
	String updatePostPage(@PathVariable Long postId, PostDto postDto){
		postService.updatePost(postId, postDto);
		return null;
	}

	@DeleteMapping("/post/{postId}")
	String deletePostPage(@PathVariable Long postId){
		postService.deletePost(postId);
		return null;
	}

}
