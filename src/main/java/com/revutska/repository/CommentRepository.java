package com.revutska.repository;

import com.revutska.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findOneById(Integer commentId);
    List<Comment> findAllByPostId(Integer postId);
}
