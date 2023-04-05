package com.jongha.mypage.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jongha.mypage.domain.Post;
import com.jongha.mypage.dto.PostDto;
import com.jongha.mypage.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;

    @Transactional
    public Long createPost(PostDto postDto) {
        Post save = postRepository.save(postDto.toEntity());
        return save.getId();
    }

    @Transactional
    public Page<Post> getPostList (Pageable pageable) {
        return  postRepository.findAll(pageable);
    }

    public Page<Post> paging(int page) {
        return postRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));
    }



    public void updatePost(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
        post.updateDescription(postDto.getDescription());
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
        commentService.deleteAllComments(postId);
    }

    public Post showOnePost(Long postId) {
        return postRepository.findById(postId).orElseThrow(RuntimeException::new);
    }


    public Page<Post> getPage(String searchText, Pageable pageable) {
        Page<Post> posts = postRepository.findByTitleContainingOrDescriptionContaining(searchText, searchText, pageable);
        return  posts;
    }
}
