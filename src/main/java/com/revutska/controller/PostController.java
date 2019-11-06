package com.revutska.controller;

import com.revutska.model.Comment;
import com.revutska.model.Post;
import com.revutska.service.CommentService;
import com.revutska.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/formPost", method = RequestMethod.GET)
    public String showFormForAdd(Model theModel) {
        Post post = new Post();
        String textCreate = "Create";
        theModel.addAttribute("title", textCreate);
        theModel.addAttribute("post", post);
        return "post-form";
    }

	@RequestMapping(value = "/formUpdatePost/{id}", method = RequestMethod.GET)
	public String showFormForUpdate(@PathVariable Integer id, Model theModel) {
		Post post = postService.getPost(id);
        String textUpdate = "Update";
        theModel.addAttribute("title", textUpdate);
		theModel.addAttribute("post", post);
		return "post-form";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String savePost(@ModelAttribute("post") Post post) {
	    postService.savePost(post);
	    return "redirect:/";
	}

	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String getPost(@PathVariable Integer id, Model theModel) {
		Post post = postService.getPost(id);
		theModel.addAttribute("post", post);
		ArrayList<Comment> comments = commentService.getAllCommentsForPost(id);
		Collections.sort(comments);
		theModel.addAttribute("comments", comments);
		return "full-post-with-comments";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable Integer id) {
		postService.deletePost(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllPosts(Model theModel) {
    	List<Post> posts = postService.getAllPosts();
    	theModel.addAttribute("posts", posts);
		return "index";
	}
}