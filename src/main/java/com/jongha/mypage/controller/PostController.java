package com.jongha.mypage.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.PostDto;
import com.jongha.mypage.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
	private final PostService postService;

	@GetMapping("/{postId}")
	public String showPostPage(@PathVariable Long postId , Model model){
		Post post = postService.showOnePost(postId);
		model.addAttribute("post", post);
		return "post/postContent";
	}

	@PostMapping("/write")
	String createPostPage( @ModelAttribute PostDto postDto, Model model){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String username = userDetails.getUsername();

		Long postId = postService.createPost(postDto);
		return null;
	}

	@PutMapping("/{postId}")
	String updatePostPage(@PathVariable Long postId, PostDto postDto){
		postService.updatePost(postId, postDto);
		return null;
	}

	@DeleteMapping("/{postId}")
	String deletePostPage(@PathVariable Long postId){
		postService.deletePost(postId);
		return null;
	}

}
