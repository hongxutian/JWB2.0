package com.hnu.server;

import com.alibaba.fastjson.JSONObject;
import com.hnu.entity.Comment;
import com.hnu.entity.newest.CommentInfoBean;
import com.hnu.repository.CommentRepository;
import com.hnu.utils.WebRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    /**
     * 按demand_id查找评论
     *
     * @param demandId
     * @return
     */
    public List<CommentInfoBean> findComments(String demandId) {
        return commentRepository.findCommentsByDemandId(demandId);
    }

    /**
     * 插入评论业务
     * 验证敏感词
     *
     * @param comment
     * @return
     */
    public String insertComment(Comment comment) {
        JSONObject back = new JSONObject();//返回的消息
        final WebRequestUtil.ContentValidate contentValidate =
                WebRequestUtil.checkContent(comment.getComment_content());
        switch (contentValidate) {
            case PASS:
                //通过
                commentRepository.insertComment(comment);
                back.put("msg", "操作成功！");
                back.put("status_code", "200");
                break;
            case FAIL:
            case TOKE_FAIL:
                //操作失败
                back.put("msg", "操作失败！");
                back.put("status_code", "500");
                break;
            case ERROR:
                //检测出错
                back.put("msg", "未知错误！");
                back.put("status_code", "500");
                break;
            case SENSITIVE:
                //不通过
                back.put("msg", "内容涉及敏感词！");
                back.put("status_code", "500");
                break;
                default:
        }
        return back.toJSONString();
    }

}
