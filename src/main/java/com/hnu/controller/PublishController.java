package com.hnu.controller;

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
import java.util.*;

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
        if(WebRequestUtil.checkContent(content.getContent() + content.getStore_name()) != WebRequestUtil.ContentValidate.PASS){
            back.put("msg", "内容涉及敏感词！");
            back.put("status_code", "500");
            return back.toJSONString();
        }
        //否则，数据合规，封装数据
        Demand demand = new Demand();
        demand.setU_id_id(content.getU_id());
        demand.setDemand_id(content.getDemand_id());
        demand.setS_lon(content.getLon());
        demand.setS_lat(content.getLat());
        demand.setS_nation(content.getNation());
        demand.setS_province(content.getProvince());
        demand.setS_city(content.getCity());
        demand.setS_district(content.getDistrict());
        demand.setS_street(content.getStreet());
        demand.setS_street_number(content.getStreet_number());
        demand.setS_content(content.getContent());
        demand.setS_type(content.getType());
        demand.setS_range(content.getRange());
        demand.setS_aging(content.getAging());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            demand.setS_subtime(format.parse(content.getSubtime()));
        } catch (ParseException e) {
            e.printStackTrace();
            demand.setS_subtime(new Date());
        }
        demand.setStore_name(content.getStore_name());


        List<PublishJson.GoodsBean> goods = content.getGoods();
        List<Material> resources = null;
        if (goods != null && goods.size()>0) {
            resources = new ArrayList<>();
            for (PublishJson.GoodsBean good : goods) {
                Material resource = new Material();
                resource.setType(content.getType());
                resource.setCount(good.getNum_or_price());
                resource.setGoods_name(good.getGoods_name());
                resources.add(resource);
            }
        }
        //存储数据
        try {
            publishServer.savePublish(demand, resources);
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
