package com.revutska.controller;

import com.revutska.model.Post;
import com.revutska.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {
	@Autowired
	private PostService postService;

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Post createPost(@RequestParam(required = false, defaultValue = "Anonymous") String creatorName, @RequestParam String text) {
		return postService.createPost(creatorName, text);
	}

	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public Post getPost(@PathVariable Integer id) {
		return postService.findPost(id);
	}

	@RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable Integer id) {
		postService.deletePost(id);
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}


}