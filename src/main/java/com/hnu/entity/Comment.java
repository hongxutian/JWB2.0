package com.hnu.entity;

import java.sql.Timestamp;

public class Comment {

    private Integer id;
    private Integer userId;
    private Integer replyCommentId;
    private String comment;
    private Timestamp insertTime;
    private long sourceId;
    private String username;
    private String replyUserName;
    private String userPhoto;


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Integer replyCommentId) {
        this.replyCommentId = replyCommentId;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public java.sql.Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(java.sql.Timestamp insertTime) {
        this.insertTime = insertTime;
    }


    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }


    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

}
