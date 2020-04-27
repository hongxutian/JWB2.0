package com.hnu.server;

import com.alibaba.fastjson.JSONObject;
import com.hnu.entity.Comment;
import com.hnu.entity.newest.CommentInfoBean;
import com.hnu.entity.newest.NewResponseJson;
import com.hnu.repository.CommentRepository;
import com.hnu.utils.WXAPPInfo;
import com.hnu.utils.WebRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        //获取访问服务端的token
        String access_token = WXAPPInfo.getAccess_token();
        if (access_token == null) {
            back.put("msg", "操作失败！");
            back.put("status_code", "500");
            return back.toJSONString();
        }
        //进行内容校验
        Map<String, String> parameter = new LinkedHashMap<>();
        parameter.put("access_token", access_token);

        JSONObject req = new JSONObject();
        req.put("content", comment.getComment_content());
        String reqRes = WebRequestUtil.wrPOST_JSON("https://api.weixin.qq.com/wxa/msg_sec_check", parameter, req.toJSONString());
        JSONObject object = WXAPPInfo.isJSON(reqRes);
        //向微信服务端申请出现异常
        if (object == null) {
            back.put("msg", "未知错误！");
            back.put("status_code", "500");
            return back.toJSONString();
        }
        //内容不合格
        if (!"ok".equals(object.getString("errmsg"))) {
            back.put("msg", "内容涉及敏感词！");
            back.put("status_code", "500");
            return back.toJSONString();
        }
        commentRepository.insertComment(comment);
        back.put("msg", "操作成功！");
        back.put("status_code", "200");
        return back.toJSONString();
    }

}
