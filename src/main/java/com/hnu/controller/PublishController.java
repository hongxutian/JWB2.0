package com.hnu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PublishController {

    @RequestMapping(value = "/UserLogin",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String publish(@RequestParam("")String s){

    }

}
