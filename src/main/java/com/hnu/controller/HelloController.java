package com.hnu.controller;

import com.hnu.utils.AppJWTUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "测试接口")
    public String hello() {
        return "hello, JWB";
    }

    @GetMapping("/t/gettoken")
    @ApiOperation(value = "测试接口，测试JWT，获取token，30分钟有效")
    public String getToken(){
        String content = Long.toString(System.currentTimeMillis());
        return AppJWTUtil.createToken(content,0,0,30,AppJWTUtil.sec);
    }

    @GetMapping("/t/verifytoken")
    @ApiOperation(value = "测试接口，测试JWT，验证token")
    public boolean verifyToken(@RequestParam String token){
        return AppJWTUtil.verifyToken(token,AppJWTUtil.sec);
    }

}
