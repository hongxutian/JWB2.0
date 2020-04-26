package com.hnu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnu.entity.Demand;
import com.hnu.entity.Material;
import com.hnu.entity.publish.PublishJson;
import com.hnu.server.PublishService;
import com.hnu.utils.WXAPPInfo;
import com.hnu.utils.WebRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PublishController {

    @Autowired
    PublishService publishServer = null;


    /**
     * 发布资源或者需求
     */
    @PostMapping(value = "/SupAndDem")
    @ResponseBody
    public String publish(@RequestBody PublishJson content, HttpServletResponse response) {
        JSONObject back = new JSONObject();//返回的消息
        response.setStatus(HttpServletResponse.SC_CREATED);//状态
        //获取访问服务端的token
        String access_token = WXAPPInfo.getAccess_token();
        if (access_token == null) {
            back.put("msg", "操作失败");
            back.put("status_code", "500");
            return back.toJSONString();
        }
        //进行内容校验
        Map<String, String> parameter = new LinkedHashMap<>();
        parameter.put("access_token", access_token);

        JSONObject req = new JSONObject();
        req.put("content", content.getContent() + content.getStore_name());
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
        //否则，数据合规，封装数据
        Demand demand = new Demand();
        demand.setuIdId(content.getU_id());
        demand.setsLon(content.getLon());
        demand.setsLat(content.getLat());
        demand.setsNation(content.getNation());
        demand.setsProvince(content.getProvince());
        demand.setsCity(content.getCity());
        demand.setsDistrict(content.getDistrict());
        demand.setsStreet(content.getStreet());
        demand.setsStreetNumber(content.getStreet_number());
        demand.setsContent(content.getContent());
        demand.setsType(content.getType());
        demand.setsRange(content.getRange());
        demand.setsAging(content.getAging());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            demand.setsSubtime(format.parse(content.getSubtime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        demand.setStoreName(content.getStore_name());


        List<PublishJson.GoodsBean> goods = content.getGoods();
        List<Material> resources = new ArrayList<>();
        if (goods != null) {
            for (PublishJson.GoodsBean good : goods) {
                Material resource = new Material();
                resource.setType(content.getType());
                resource.setCount(good.getNum_or_price());
                resource.setGoodsName(good.getGoods_name());
                resources.add(resource);
            }
        }
        //存储数据
        try {
            System.out.println("before");
            publishServer.savePublish(demand, resources);
            System.out.println("after");
            back.put("msg", "操作成功！");
            back.put("status_code", "201");
            return back.toJSONString();
        } catch (RuntimeException e) {
            e.printStackTrace();
            back.put("msg", "发布失败！");
            back.put("status_code", "500");
            return back.toJSONString();
        }
    }


}
