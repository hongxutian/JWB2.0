package com.hnu.server;

import com.hnu.entity.Comment;
import com.hnu.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getComments(int sourceId, int limited, int offset) {
       return commentRepository.getComments(sourceId, limited, offset);
    }

    public void insertComment(Comment comment) {
        commentRepository.insertComment(comment);
    }
}
