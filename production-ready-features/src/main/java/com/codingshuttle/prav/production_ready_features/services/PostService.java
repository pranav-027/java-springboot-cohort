package com.codingshuttle.prav.production_ready_features.services;

import com.codingshuttle.prav.production_ready_features.dto.PostDto;
import java.util.List;


public interface PostService {

	List<PostDto> getAllPosts();

	PostDto createNewPost(PostDto postDto);

	PostDto getPostById(Long postId);

	PostDto updatePost(Long postId, PostDto postDto);
}
