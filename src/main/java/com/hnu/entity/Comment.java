package com.hnu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "提交评论的内容")
public class Comment {


    /**
     * u_id :
     * demand_id :
     * comment_content : 评论内容
     * subtime : 2020-03-02 12:12:12
     */

    @ApiModelProperty(value = "用户的id")
    private String u_id;
    @ApiModelProperty(value = "被评论的发布信息的id")
    private String demand_id;
    @ApiModelProperty(value = "评论的内容")
    private String comment_content;
    @ApiModelProperty(value = "评论的时间",example = "2020-02-23-23 13:23:23")
    private String subtime;

    private String replyId;

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

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }
}
