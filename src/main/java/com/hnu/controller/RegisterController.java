package com.hnu.controller;

import com.hnu.entity.UserInfo;
import com.hnu.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping("/UserRegister")
    public String register(@RequestBody UserInfo userInfo) {
        //利用open_id验证用户是否注册过
        if (userInfoRepository.findByOpenId(userInfo.getOpenId()) != null) {
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
