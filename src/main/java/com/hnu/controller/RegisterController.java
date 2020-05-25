package com.hnu.controller;

import com.hnu.entity.user.UserInfo;
import com.hnu.repository.UserInfoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RegisterController {

    private final UserInfoRepository userInfoRepository;

    public RegisterController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @PostMapping("/UserRegister")
    @ApiOperation(value = "用户注册接口",notes = "返回的内容为JSON字符串，{\"msg\":\"UserRegistered\"}和{\"msg\": \"NewUserRegisterSuccess\"}和{\"msg\": \"UserInfoChanged\"}和{\"msg\": \"UnknownError\"}")
    public String register(@RequestBody @ApiParam("提交的用户基本信息") UserInfo userInfo) {
        try{
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+":");
            System.out.println("用户注册");
            System.out.println("用户信息:\n"+userInfo.toString());
            //利用open_id验证用户是否注册过
            UserInfo userInfo1 = userInfoRepository.findByOpenId(userInfo.getOpen_id());
            if (userInfo1 != null) {
                System.out.println("用户已注册");
                if(!userInfo1.equals(userInfo)){
                    userInfo.setId(userInfo1.getId());
                    userInfoRepository.updateUserInfoById(userInfo);
                    return "{\"msg\": \"UserInfoChanged\"}";
                }else {
                    return "{\"msg\": \"UserRegistered\"}";
                }
            }else {
                //未注册用户
                userInfoRepository.save(userInfo);
                System.out.println("用户注册成功");
                return "{\"msg\": \"NewUserRegisterSuccess\"}";
            }
        }catch (RuntimeException e){
            e.printStackTrace();
            return "{\"msg\": \"UnknownError\"}";
        }
    }
}
