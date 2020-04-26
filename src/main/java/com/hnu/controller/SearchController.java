package com.hnu.controller;

import com.hnu.server.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService = null;

    @GetMapping(value = "/storeList/1/")
    @ResponseBody
    public String search(@RequestParam("keyword") String keyword,
                         @RequestParam("page_items_count") int page_items_count,
                         String current_position) {
        try {
            int temp;
            if (current_position == null || "".equals(current_position)) {
                temp = 0;
            } else {
                temp = Integer.parseInt(current_position);
            }
            return searchService.searchStores(keyword, page_items_count, temp);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
