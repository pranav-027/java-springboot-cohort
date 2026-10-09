package com.codingshuttle.securityApplication.services.impl;

import java.util.List;

import com.codingshuttle.securityApplication.dtos.PostDto;
import com.codingshuttle.securityApplication.entities.PostEntity;
import com.codingshuttle.securityApplication.exceptions.ResourceNotFoundException;
import com.codingshuttle.securityApplication.repository.PostEntityRepository;
import com.codingshuttle.securityApplication.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final ModelMapper modelMapper;

	private final PostEntityRepository postEntityRepository;

	@Override
	public List getAllPosts() {
		return postEntityRepository.findAll()
				.stream()
				.map(postEntity -> modelMapper.map(postEntity, PostDto.class))
				.toList();
	}

	@Override
	public PostDto createNewPost(PostDto postDto) {
		PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
		postEntity.setId(null); // Ensure the ID is null so that a new entity is created
		return modelMapper.map(postEntityRepository.save(postEntity), PostDto.class);
	}

	@Override
	public PostDto getPostById(Long postId) throws Throwable {
		PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
		return modelMapper.map(postEntity, PostDto.class);
	}

	@Override
	public PostDto updatePost(Long postId, PostDto postDto) throws Throwable {
		PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
		PostEntity updatablePostEntity = modelMapper.map(postDto, PostEntity.class);
		updatablePostEntity.setId(postEntity.getId());
		return modelMapper.map(postEntityRepository.save(updatablePostEntity), PostDto.class);
	}
}
