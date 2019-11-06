package com.revutska.service;

import com.revutska.controller.CommentController;
import com.revutska.model.Post;
import com.revutska.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PostService {
    private static final String DEFAULT_CREATOR_NAME = "Anonymous";

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentController commentController;

    public void savePost(Post post) {
        final Integer postId = post.getId();
        post.setId(postId);
        post.setDateOfCreation(new Date());
        if (post.getCreatorName().trim().equals(""))
            post.setCreatorName(DEFAULT_CREATOR_NAME);
        postRepository.save(post);
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
        commentController.deleteAllCommentsFromPost(postId);
    }

    public Post getPost(Integer postId) {
        return postRepository.findOneById(postId);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
