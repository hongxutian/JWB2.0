package com.hnu.controller;

import com.alibaba.fastjson.JSON;
import com.hnu.entity.login.LoginRespJson;
import com.hnu.entity.login.LoginResponseJson;
import com.hnu.entity.user.UserInfo;
import com.hnu.repository.UserInfoRepository;
import com.hnu.utils.AppJWTUtil;
import com.hnu.utils.WXAPPInfo;
import com.hnu.utils.WebRequestUtil;
import org.springframework.web.bind.annotation.*;
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
    public LoginRespJson userLogin(@RequestParam("js_code") String js_code){

        Map<String,String> req = new LinkedHashMap<>();
        req.put("appid", WXAPPInfo.appid);
        req.put("secret",WXAPPInfo.secret);
        req.put("js_code",js_code);
        req.put("grant_type","authorization_code");
        String result = WebRequestUtil.wrGET("https://api.weixin.qq.com/sns/jscode2session",req);
        final LoginResponseJson responseJson = JSON.parseObject(result, LoginResponseJson.class);
        LoginRespJson respJson = new LoginRespJson();
        //测试
        System.out.println(Objects.requireNonNull(responseJson).toString());
        if (responseJson.getErrcode() == 0) {
            //登录成功
            //生成token,有效期30分钟
            String token = AppJWTUtil.createToken(responseJson.getOpenid(),0,0,30, AppJWTUtil.sec);
            System.out.println(token);
            final UserInfo userInfo = userInfoRepository.findByOpenId(responseJson.getOpenid());
            if (userInfo != null) {
                respJson.setGender(userInfo.getGender());
                respJson.setOpen_id(userInfo.getOpen_id());
                respJson.setAvatar_utl(userInfo.getAvatar_url());
                respJson.setU_type(userInfo.getU_type());
                respJson.setNick_name(userInfo.getNick_name());
                respJson.setToken(token);
            }
            return respJson;
        }else {
            //登录失败
            return respJson;
        }
    }

}
