package com.revutska.controller;

import com.revutska.model.Comment;
import com.revutska.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/formComment/{postId}", method = RequestMethod.GET)
    public String showFormForAdd(Model theModel, @PathVariable Integer postId) {
        Comment comment = new Comment();
        comment.setPostId(postId);
        String textCreate = "Create";
        theModel.addAttribute("title", textCreate);
        theModel.addAttribute("comment", comment);
        return "comment-form";
    }

    @RequestMapping(value = "/formUpdateComment/{postId}/{commentId}", method = RequestMethod.GET)
    public String showFormForUpdate(Model theModel, @PathVariable Integer postId, @PathVariable Integer commentId) {
        Comment comment = commentService.getComment(commentId);
        comment.setPostId(postId);
        String textUpdate = "Update";
        theModel.addAttribute("title", textUpdate);
        theModel.addAttribute("comment", comment);
        return "comment-form";
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable Integer commentId) {
        return commentService.getComment(commentId);
    }

    @RequestMapping(value = "/comments/{postId}", method = RequestMethod.GET)
    public ArrayList<Comment> getAllCommentsForPost(@PathVariable Integer postId) {
        return commentService.getAllCommentsForPost(postId);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String saveCommentToPost(@ModelAttribute("comment") Comment comment) {
        commentService.saveCommentToPost(comment);
        return "redirect:/post/" + comment.getPostId();
    }

    @RequestMapping(value = "/comment/delete/{commentId}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable Integer commentId) {
        Integer postId = commentService.getComment(commentId).getPostId();
        commentService.deleteComment(commentId);
        return "redirect:/post/" + postId;
    }

    @RequestMapping(value = "/comments/delete/{postId}", method = RequestMethod.GET)
    public void deleteAllCommentsFromPost(@PathVariable Integer postId) {
        commentService.deleteAllCommentsFromPost(postId);
    }
}
