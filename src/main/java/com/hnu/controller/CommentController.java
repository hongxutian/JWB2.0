package com.hnu.controller;

import com.hnu.entity.Comment;
import com.hnu.entity.newest.CommentInfoBean;
import com.hnu.server.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public List<CommentInfoBean> getComment() {
        return commentService.findComments("");
    }

    @PostMapping("/SubComment")
    public String subComment(@RequestBody Comment comment) {
        return commentService.insertComment(comment);
    }
}
