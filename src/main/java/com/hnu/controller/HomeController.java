package com.hnu.controller;

import com.hnu.entity.Demand;
import com.hnu.entity.Limit;
import com.hnu.entity.NewJson;
import com.hnu.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private DemandRepository demandRepository;

    @PostMapping("/new/{page}")
    @ResponseBody
    public List<Demand> newest(@RequestBody NewJson newJson, @PathVariable int page) {

        System.out.println(newJson);
        //计算经纬度搜索范围 纬度1度是111KM,1分是1.85KM
        float max_lon = Float.parseFloat(newJson.getLongitude()) + Float.parseFloat(newJson.getSearchRange()) / 111;
        float min_lon = Float.parseFloat(newJson.getLongitude()) - Float.parseFloat(newJson.getSearchRange()) / 111;
        float max_lat = Float.parseFloat(newJson.getLatitude()) + Float.parseFloat(newJson.getSearchRange()) / 111;
        float min_lat = Float.parseFloat(newJson.getLatitude()) - Float.parseFloat(newJson.getSearchRange()) / 111;
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(newJson.getStartTime());
            Date date2 = format.parse(newJson.getEndTime());
            //查询符合条件的需求数据
            Limit limit = new Limit(max_lon, min_lon, max_lat, min_lat, date1, date2);
            List<Demand> demands = demandRepository.findByRange(limit);
            return demands;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}


