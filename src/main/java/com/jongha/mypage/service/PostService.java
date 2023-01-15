package com.jongha.mypage.service;

import org.springframework.stereotype.Service;

import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.PostDto;
import com.jongha.mypage.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;
	private final CommentService commentService;

	public Long createPost(PostDto postDto){
		Post post = Post.builder().user(null).title(postDto.getTitle()).description(postDto.getDescription()).build();
		postRepository.save(post);
		return post.getId();
	}
	public void updatePost(Long postId, PostDto postDto){
		Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
		post.updateDescription(postDto.getDescription());
	}
	public void deletePost(Long postId){
		postRepository.deleteById(postId);
		commentService.deleteAllComments(postId);
	};

	public Post showOnePost(Long postId){
		return postRepository.findById(postId).orElseThrow(RuntimeException::new);
	}
}
