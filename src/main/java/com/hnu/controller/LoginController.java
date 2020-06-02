package com.hnu.controller;

import com.alibaba.fastjson.JSON;
import com.hnu.entity.login.LoginRespJson;
import com.hnu.entity.login.LoginResponseJson;
import com.hnu.entity.user.UserInfo;
import com.hnu.repository.UserInfoRepository;
import com.hnu.utils.AppJWTUtil;
import com.hnu.utils.WXAPPInfo;
import com.hnu.utils.WebRequestUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    private final UserInfoRepository userInfoRepository;

    public LoginController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    /**
     * 用户登录的接口
     * @param js_code 客户端在微信登录时获取的code
     * @return 请求微信服务器后返回的
     */
    @RequestMapping(value = "/UserLogin",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "用户登录接口")
    public LoginRespJson userLogin(@RequestParam("js_code") @ApiParam(value = "小程序打开时从微信后台获取的",required = true) String js_code){

        Map<String,String> req = new LinkedHashMap<>();
        req.put("appid", WXAPPInfo.appid);
        req.put("secret",WXAPPInfo.secret);
        req.put("js_code",js_code);
        req.put("grant_type","authorization_code");
        String result = WebRequestUtil.wrGET("https://api.weixin.qq.com/sns/jscode2session",req);
        final LoginResponseJson responseJson = JSON.parseObject(result, LoginResponseJson.class);
        LoginRespJson respJson = new LoginRespJson();
        //测试
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+":");
        System.out.println("用户登陆");
        System.out.println("微信返回:"+Objects.requireNonNull(responseJson).toString());
        if (responseJson.getErrcode() == 0) {
            //登录成功
            //生成token,有效期30分钟
            String token = AppJWTUtil.createToken(responseJson.getOpenid(),0,0,30, AppJWTUtil.sec);
            System.out.println("token:"+token);
            respJson.setOpen_id(responseJson.getOpenid());
            respJson.setToken(token);
            System.out.println("登陆成功");
            return respJson;
        }else {
            //登录失败
            respJson.setOpen_id("");
            respJson.setToken("");
            System.out.println("登陆失败");
            return respJson;
        }
    }

}
