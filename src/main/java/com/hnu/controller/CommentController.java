package com.hnu.controller;

import com.hnu.entity.Comment;
import com.hnu.entity.newest.CommentInfoBean;
import com.hnu.server.CommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    /**
     * 测试接口
     *
     * @return
     */
    @GetMapping("/comment")
    public List<CommentInfoBean> getComment() {
        return commentService.findComments("");
    }

    @PostMapping("/SubComment")
    @ApiOperation(value = "发布评论",notes = "返回的内容有如下之一:" +
            "{\"status_code\":\"200\",\"msg\":\"操作成功！\"}," +
            "{\"status_code\":\"500\",\"msg\":\"操作失败！\"}," +
            "{\"status_code\":\"500\",\"msg\":\"未知错误！\"}," +
            "{\"status_code\":\"500\",\"msg\":\"内容涉及敏感词！\"}")
    public String subComment(@RequestBody @ApiParam("请求的内容") Comment comment) {
        return commentService.insertComment(comment);
    }
}
