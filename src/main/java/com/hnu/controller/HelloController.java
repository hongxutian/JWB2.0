package com.hnu.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "测试接口")
    public String hello() {
        return "hello, JWB";
    }

}
