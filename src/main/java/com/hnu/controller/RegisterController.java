package com.hnu.controller;

import com.hnu.entity.user.UserInfo;
import com.hnu.repository.UserInfoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final UserInfoRepository userInfoRepository;

    public RegisterController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @PostMapping("/UserRegister")
    @ApiOperation(value = "用户注册接口",notes = "返回的内容为JSON字符串，{\"msg\":\"UserRegistered\"}和{\"msg\": \"NewUserRegisterSuccess\"}")
    public String register(@RequestBody @ApiParam("提交的用户基本信息") UserInfo userInfo) {
        //利用open_id验证用户是否注册过
        if (userInfoRepository.findByOpenId(userInfo.getOpen_id()) != null) {
            System.out.println("用户已注册");
            return "{\"msg\": \"UserRegistered\"}";
        }else {
            //未注册用户
            userInfoRepository.save(userInfo);
            System.out.println("用户注册成功");
            return "{\"msg\": \"NewUserRegisterSuccess\"}";
        }

    }
}
