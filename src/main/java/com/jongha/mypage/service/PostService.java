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
    public Page<Post> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Page<Post> paging(int page) {
        return postRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));
    }


    @Transactional
    public void updateVisit(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));
        post.updateCountVisit(postDto.getCountVisit());

        log.info("Post : update Count Visit");
    }


    @Transactional
    public void updatePost(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다"));
        post.updateDescription(postDto.getDescription());
        log.info("Post : update Description");
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
        return posts;
    }
}
