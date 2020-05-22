package com.hnu.entity.newest;

public class CommentInfoBean {

    /**
     * comment_content :
     * c_nick_name :
     * c_avatar_url :
     * c_subtime :
     */

    private String comment_content;
    private String c_uid;
    private String c_nick_name;
    private String c_avatar_url;
    private String c_subtime;

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getC_nick_name() {
        return c_nick_name;
    }

    public void setC_nick_name(String c_nick_name) {
        this.c_nick_name = c_nick_name;
    }

    public String getC_avatar_url() {
        return c_avatar_url;
    }

    public void setC_avatar_url(String c_avatar_url) {
        this.c_avatar_url = c_avatar_url;
    }

    public String getC_subtime() {
        return c_subtime;
    }

    public void setC_subtime(String c_subtime) {
        this.c_subtime = c_subtime;
    }

    public String getC_uid() {
        return c_uid;
    }

    public void setC_uid(String c_uid) {
        this.c_uid = c_uid;
    }
}
