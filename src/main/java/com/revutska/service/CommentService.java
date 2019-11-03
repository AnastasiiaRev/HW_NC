package com.revutska.service;

import com.revutska.model.Comment;
import com.revutska.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(String creatorName, String text, Integer postId) {
        Comment comment = new Comment();
        comment.setDateOfCreation(new Date());
        comment.setCreatorName(creatorName);
        comment.setText(text);
        comment.setPostId(postId);
        commentRepository.save(comment);
        return comment;
    }

    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findOneById(commentId);
        if (comment == null)
            throw new EntityNotFoundException("Comment not found");
        commentRepository.delete(comment);
    }

    public void deleteComments(Integer postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        if (comments.isEmpty())
            throw new EntityNotFoundException("Comments not found");
        for (Comment comment : comments)
            commentRepository.delete(comment);
    }
}
