package com.revutska.service;

import com.revutska.model.Post;
import com.revutska.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post createPost(String creatorName, String text) {
        Post post = new Post();
        final Integer postId = post.getId();
        post.setId(postId);
        post.setDateOfCreation(new Date());
        post.setCreatorName(creatorName);
        post.setText(text);
        postRepository.save(post);
        return post;
    }

    @Transactional
    public void deletePost(Integer postId) {
        Post post = postRepository.findOneById(postId);
        if (post == null)
            throw new EntityNotFoundException("Post not found");
        postRepository.deleteById(postId);

    }

    @Transactional
    public Post findPost(Integer postId) {
        return postRepository.findOneById(postId);
    }

    @Transactional
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
