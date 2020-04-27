package com.hnu.controller;

import com.hnu.entity.Comment;
import com.hnu.entity.Demand;
import com.hnu.entity.newest.CommentInfoBean;
import com.hnu.entity.newest.Limit;
import com.hnu.entity.Material;
import com.hnu.entity.me.MeJson;
import com.hnu.entity.newest.NewJson;
import com.hnu.entity.newest.NewResponseJson;
import com.hnu.repository.CommentRepository;
import com.hnu.repository.DemandRepository;
import com.hnu.repository.MaterialRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {

    private final DemandRepository demandRepository;
    private final MaterialRepository materialRepository;
    private final CommentRepository commentRepository;

    public HomeController(DemandRepository demandRepository, MaterialRepository materialRepository, CommentRepository commentRepository) {
        this.demandRepository = demandRepository;
        this.materialRepository = materialRepository;
        this.commentRepository = commentRepository;
    }

    @PostMapping("/new/{page}")
    @ResponseBody
    public List<NewResponseJson> newest(@RequestBody NewJson newJson, @PathVariable() int page) {

        System.out.println(newJson);
        //计算经纬度搜索范围 纬度1度是111KM,1分是1.85KM
        return getNewAndNearbyResponse(newJson, page);
    }

    @PostMapping("/me/{page}")
    public List<NewResponseJson> getMe(@RequestBody MeJson meJson, @PathVariable int page) {
//        返回结果和最新的json格式一致
        int counts = Integer.parseInt(meJson.getPage_items_count());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(meJson.getStart_time());
            Date date2 = format.parse(meJson.getEnd_time());
            //查询符合条件的需求数据
            Limit limit = new Limit(180, 0, 90, 0, date1, date2, (page - 1) * counts, counts);
            return getResponseJsons(format, limit);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @PostMapping("/nearby/{page}")
    public List<NewResponseJson> getNearBy(@RequestBody NewJson newJson, @PathVariable int page) {
        System.out.println("start --> getNearBy");
        //计算经纬度搜索范围 纬度1度是111KM,1分是1.85KM
        return getNewAndNearbyResponse(newJson, page);
    }

    private List<NewResponseJson> getNewAndNearbyResponse(@RequestBody NewJson newJson, @PathVariable int page) {
        float max_lon = Float.parseFloat(newJson.getLongitude()) + Float.parseFloat(newJson.getSearchRange()) / 111;
        float min_lon = Float.parseFloat(newJson.getLongitude()) - Float.parseFloat(newJson.getSearchRange()) / 111;
        float max_lat = Float.parseFloat(newJson.getLatitude()) + Float.parseFloat(newJson.getSearchRange()) / 111;
        float min_lat = Float.parseFloat(newJson.getLatitude()) - Float.parseFloat(newJson.getSearchRange()) / 111;
        int counts = Integer.parseInt(newJson.getPageItemsCount());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(newJson.getStartTime());
            Date date2 = format.parse(newJson.getEndTime());
            //查询符合条件的需求数据
            Limit limit = new Limit(max_lon, min_lon, max_lat, min_lat, date1, date2, (page - 1) * counts, counts);
            return getResponseJsons(format, limit);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<NewResponseJson> getResponseJsons(SimpleDateFormat format, Limit limit) {

        List<Demand> demands = demandRepository.findByRange(limit);
//            生成返回实体类
        List<NewResponseJson> responseJsonList = new ArrayList<>();
        for (Demand demand : demands) {
            NewResponseJson responseJson = new NewResponseJson();
            responseJson.setAvatar_url(demand.getAvatar_url());
            responseJson.setDemand_id(demand.getDemand_id());
            responseJson.setNick_name(demand.getNick_name());
            responseJson.setStore_name(demand.getStore_name());
            responseJson.setS_lon(demand.getS_lon());
            responseJson.setS_lat(demand.getS_lat());
            responseJson.setS_nation(demand.getS_nation());
            responseJson.setS_city(demand.getS_city());
            responseJson.setS_province(demand.getS_province());
            responseJson.setS_street(demand.getS_street());
            responseJson.setS_street_number(demand.getS_street_number());
            responseJson.setS_content(demand.getS_content());
            responseJson.setS_type(demand.getS_type());
            responseJson.setS_range(demand.getS_range());
            responseJson.setS_aging(demand.getS_aging());
            responseJson.setS_subtime(format.format(demand.getS_subtime()));
            // 查找物料详情
            final List<Material> materialList = materialRepository.findMaterialById(demand.getU_id_id());
            List<NewResponseJson.DetailsInfoBean> beans = new ArrayList<>();
            for (Material material : materialList) {
                NewResponseJson.DetailsInfoBean bean = new NewResponseJson.DetailsInfoBean();
                bean.setType(material.getType());
                bean.setGoods_name(material.getGoods_name());
                bean.setCount((int) material.getCount());
                beans.add(bean);
            }
            // 查询评论信息
            List<CommentInfoBean> commentList = commentRepository.findCommentsByDemandId(demand.getDemand_id());
            responseJson.setDetails_info(beans);
            responseJson.setComment_info(commentList);
            responseJsonList.add(responseJson);
        }
        return responseJsonList;
    }
}


