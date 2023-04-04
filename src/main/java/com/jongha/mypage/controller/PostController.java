package com.jongha.mypage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.PostDto;
import com.jongha.mypage.service.PostService;

import lombok.RequiredArgsConstructor;

import java.awt.print.Pageable;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
	private final PostService postService;

	@GetMapping("/postForm")
	public String addPost() {
		return "/post/postForm";
	}

	@PostMapping("/postForm")
	String createPostPage( @ModelAttribute PostDto postDto, Model model){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String username = userDetails.getUsername();
		PostDto build = PostDto.builder().createdBy(username).countVisit(1L).build();
		Long postId = postService.createPost(build);
		log.info("Post 생성 :" + postId);

		return "redirect:/";
	}

	@GetMapping("/postList")
	public String postList(Model model, @PageableDefault(size=10)Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchText) {

		Page<Post> posts = postService.getPage();
		int startPage = Math.max(1, posts.getPageable().getPageNumber() - 1);
		int endPage = Math.min(posts.getTotalPages(), posts.getPageable().getPageNumber() + 3);

		model.addAttribute("posts", posts);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "post/postList";
	}

	@GetMapping("/{postId}")
	public String showPostPage(@PathVariable Long postId , Model model){
		Post post = postService.showOnePost(postId);
		model.addAttribute("post", post);
		return "post/postContent";
	}

	@PutMapping("/{postId}")
	public String updatePostPage(@PathVariable Long postId, PostDto postDto){
		postService.updatePost(postId, postDto);
		return null;
	}

	@DeleteMapping("/{postId}")
	public String deletePostPage(@PathVariable Long postId){
		postService.deletePost(postId);
		return null;
	}



}
