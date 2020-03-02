package com.hnu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnu.entity.Resource;
import com.hnu.entity.Suppdema;
import com.hnu.server.PublishService;
import com.hnu.utils.WXAPPInfo;
import com.hnu.utils.WebRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PublishController {

    @Autowired
    PublishService publishServer = null;


    /**
     *发布资源或者需求
     */
    @RequestMapping(value = "/SupAndDem",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String publish(@RequestBody JSONObject content,HttpServletResponse response){
        JSONObject back = new JSONObject();//返回的消息
        response.setStatus(HttpServletResponse.SC_CREATED);//状态
        //获取访问服务端的token
        String access_token = WXAPPInfo.getAccess_token();
        if(access_token == null){
            back.put("msg","操作失败");
            back.put("status_code","500");
            return back.toJSONString();
        }
        //进行内容校验
        Map<String,String> parameter = new LinkedHashMap<>();
        parameter.put("access_token",access_token);

        JSONObject req = new JSONObject();
        req.put("content",content.getString("content")+content.getString("store_name"));
        String reqRes = WebRequestUtil.wrPOST_JSON("https://api.weixin.qq.com/wxa/msg_sec_check",parameter,req.toJSONString());
        JSONObject object = WXAPPInfo.isJSON(reqRes);
        //向微信服务端申请出现异常
        if(object == null){
            back.put("msg","未知错误！");
            back.put("status_code","500");
            return back.toJSONString();
        }
        //内容不合格
        if(!"ok".equals(object.getString("errmsg"))){
            back.put("msg","内容涉及敏感词！");
            back.put("status_code","500");
            return back.toJSONString();
        }
        //封装数据
        Suppdema suppdema = new Suppdema();
        suppdema.setUIdId(content.getLongValue("u_id"));
        suppdema.setSLon(content.getBigDecimal("lon"));
        suppdema.setSLat(content.getBigDecimal("lat"));
        suppdema.setSNation(content.getString("nation"));
        suppdema.setSProvince(content.getString("province"));
        suppdema.setSCity(content.getString("city"));
        suppdema.setSDistrict(content.getString("district"));
        suppdema.setSStreet(content.getString("street"));
        suppdema.setSStreetNumber(content.getString("street_number"));
        suppdema.setSContent(content.getString("content"));
        suppdema.setSType(content.getLongValue("type"));
        suppdema.setSRange(content.getLongValue("range"));
        suppdema.setSAging(content.getLongValue("aging"));
        suppdema.setSSubtime(content.getSqlDate("subtime"));
        if(content.getString("store_name")==null){
            suppdema.setStoreName("");
        }else {
            suppdema.setStoreName(content.getString("store_name"));
        }


        JSONArray array = content.getJSONArray("goods");
        List<Resource> resources = new ArrayList<>();
        for(int i=0;i<array.size();i++){
            JSONObject temp = array.getJSONObject(i);
            Resource resource = new Resource();
            resource.setGoodsName(temp.getString("goods_name"));
            resource.setCount(temp.getFloat("num_or_price"));
            resource.setType(i);
            resources.add(resource);
        }
        //存储数据
        try {
            publishServer.savePublish(suppdema,resources);
            back.put("msg","操作成功！");
            back.put("status_code","201");
            return back.toJSONString();
        }catch (RuntimeException e){
            e.printStackTrace();
            back.put("msg","发布失败！");
            back.put("status_code","500");
            return back.toJSONString();
        }
    }



}
