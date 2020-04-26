package com.hnu.controller;

import com.hnu.entity.Comment;
import com.hnu.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List getComments(@RequestParam(name = "sourceId") int sourceId,
                            @RequestParam("limited") int limited,
                            @RequestParam("offset") int offset) {
        //
        return commentService.getComments(sourceId, limited, offset);
    }

    @PostMapping("/insertComment")
    public String insertComment(@RequestBody Comment comment) {
        commentService.insertComment(comment);
        return "ok";
    }
}
