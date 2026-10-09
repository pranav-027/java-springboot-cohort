package com.codingshuttle.securityApplication.controllers;

import java.util.List;

import com.codingshuttle.securityApplication.dtos.PostDto;
import com.codingshuttle.securityApplication.factory.RestResponseFactory;
import com.codingshuttle.securityApplication.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

	private final PostService postService;


	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPosts() {
		return ResponseEntity.ok(postService.getAllPosts());
	}

	@PostMapping
	public ResponseEntity<PostDto> createNewPost(@RequestBody  PostDto postDto) {
		System.out.println("Creating new post: " + postDto.getTitle());
		return RestResponseFactory.buildOkResponse(postService.createNewPost(postDto));
	}

	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Long postId) throws Throwable {
		return ResponseEntity.ok(postService.getPostById(postId));
	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody PostDto postDto) throws Throwable {
		// Implement the update logic here
		return ResponseEntity.ok(postService.updatePost(postId, postDto));
	}



}
