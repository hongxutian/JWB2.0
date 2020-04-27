package com.hnu.repository;

import com.hnu.entity.Comment;
import com.hnu.entity.newest.CommentInfoBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository {

    List<CommentInfoBean> findCommentsByDemandId(String demandId);

    /**
     * 插入评论
     *
     * @param comment
     */
    void insertComment(Comment comment);
}
