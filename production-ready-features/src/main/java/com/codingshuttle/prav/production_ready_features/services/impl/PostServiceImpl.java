package com.codingshuttle.prav.production_ready_features.services.impl;

import com.codingshuttle.prav.production_ready_features.dto.PostDto;
import com.codingshuttle.prav.production_ready_features.entities.PostEntity;
import com.codingshuttle.prav.production_ready_features.exceptions.ResourceNotFoundException;
import com.codingshuttle.prav.production_ready_features.repositories.PostEntityRepository;
import com.codingshuttle.prav.production_ready_features.services.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final ModelMapper modelMapper;

	private final PostEntityRepository postEntityRepository;

	@Override
	public List<PostDto> getAllPosts() {
		return postEntityRepository.findAll()
				.stream()
				.map(postEntity -> modelMapper.map(postEntity, PostDto.class))
				.toList();
	}

	@Override
	public PostDto createNewPost(PostDto postDto) {
		PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
		return modelMapper.map(postEntityRepository.save(postEntity), PostDto.class);
	}

	@Override
	public PostDto getPostById(Long postId) {
		PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
		return modelMapper.map(postEntity, PostDto.class);
	}
}
