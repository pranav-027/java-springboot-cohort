package com.codingshuttle.securityApplication.services;

import com.codingshuttle.securityApplication.dtos.PostDto;

import java.util.List;


public interface PostService {

	List<PostDto> getAllPosts();

	PostDto createNewPost(PostDto postDto);

	PostDto getPostById(Long postId) throws Throwable;

	PostDto updatePost(Long postId, PostDto postDto) throws Throwable;
}
