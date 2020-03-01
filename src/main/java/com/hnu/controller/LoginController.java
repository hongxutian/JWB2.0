package com.hnu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnu.utils.WebRequestUtil;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class LoginController {

    private static String appid="wxb038b5f6187b1412";//微信小程序的appid
    private static String secret="";//微信小程序的secret

    /**
     * 用户登录的接口
     * @param js_code 客户端在微信登录时获取的code
     * @return 请求微信服务器后返回的
     */
    @RequestMapping(value = "/UserLogin",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String userLogin(@RequestParam("js_code") String js_code){

        Map<String,String> req = new LinkedHashMap<>();
        req.put("appid",appid);
        req.put("secret",secret);
        req.put("js_code",js_code);
        req.put("grant_type","authorization_code");
        return WebRequestUtil.wrGET("https://api.weixin.qq.com/sns/jscode2session",req);
    }

    /**
     * 获取小程序全局唯一后台接口调用凭据（access_token）。调用绝大多数后台接口时都需使用 access_token
     * @return 请求成功时，返回一个JSON对象，包含access_token和有效时长（以秒为时间单位）
     */
    public static JSONObject getAccessToken(){
        Map<String,String> req = new LinkedHashMap<>();
        req.put("grant_type","client_credential");
        req.put("appid",appid);
        req.put("secret",secret);
        String res = WebRequestUtil.wrGET("https://api.weixin.qq.com/cgi-bin/token",req);
        JSONObject object = isJSON(res);
        if(object == null){
            return null;
        }
        if(object.containsKey("access_token")){
            return object;
        }
        return null;
    }

    /**
     * 判断字符串是否是JSON
     * @param src 待判断的字符串
     * @return 是JSON返回一个JSON对象，否则返回null
     */
    private static JSONObject isJSON(String src){
        try {
            return JSONObject.parseObject(src);
        }catch (RuntimeException e){
            return null;
        }
    }

}
