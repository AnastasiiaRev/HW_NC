package com.revutska.controller;

import com.revutska.model.Comment;
import com.revutska.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/{postId}", method = RequestMethod.POST)
    public Comment createComment(@PathVariable Integer postId, @RequestParam(required = false, defaultValue = "Anonymous") String creatorName, @RequestParam String text) {
        return commentService.addComment(creatorName, text, postId);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }

    @RequestMapping(value = "/comments/{postId}", method = RequestMethod.DELETE)
    public void deleteAllComments(@PathVariable Integer postId) {
        commentService.deleteComments(postId);
    }
}
