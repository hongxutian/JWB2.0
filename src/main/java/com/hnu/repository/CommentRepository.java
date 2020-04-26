package com.hnu.repository;

import com.hnu.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository {

    List<Comment> getComments(int sourceId, int limited, int offset);

    void insertComment(Comment comment);
}
