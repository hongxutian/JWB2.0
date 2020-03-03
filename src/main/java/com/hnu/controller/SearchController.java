package com.hnu.controller;

import com.alibaba.fastjson.JSON;

import com.hnu.entity.UserInfo;
import com.hnu.server.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService = null;

    @RequestMapping(value = "/storeList/1/",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String search(@RequestParam("keyword")String keyword,
                         @RequestParam("page_items_count") int page_items_count,
                         String current_position){
        try {
            int temp=0;
            if(current_position == null||"".equals(current_position)){
                temp=0;
            }else {
                temp=Integer.parseInt(current_position);
            }
            return searchService.searchStores(keyword,page_items_count,temp);
        }catch (RuntimeException e){
            return null;
        }
    }
}
