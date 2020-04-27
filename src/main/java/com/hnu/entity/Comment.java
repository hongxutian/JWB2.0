package com.hnu.entity;

public class Comment {


    /**
     * u_id :
     * demand_id :
     * comment_content : 评论内容
     * subtime : 2020-03-02 12:12:12
     */

    private String u_id;
    private String demand_id;
    private String comment_content;
    private String subtime;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(String demand_id) {
        this.demand_id = demand_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getSubtime() {
        return subtime;
    }

    public void setSubtime(String subtime) {
        this.subtime = subtime;
    }
}
