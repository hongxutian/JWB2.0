package com.hnu.utils;


import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class WebRequestUtil {


    public enum ContentValidate {
        PASS, FAIL, ERROR, SENSITIVE, TOKE_FAIL
    }

    private static OkHttpClient client = new OkHttpClient();//请求的客户端，可设置为静态对象，不用每次请求都重新创建一个对象

    //网络请求的实验函数，调用方式WebRequestUtil.webRequest();
    public static String wrGET(String url, Map<String, String> content) {
        //添加请求的参数
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (!content.isEmpty()) {
            sb.append("?");
            for (String key : content.keySet()) {
                sb.append(key).append("=").append(content.get(key)).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        url = sb.toString();
        //生成请求的对象
        //先创建builder对象，通过builder对象创建请求对象
        Request.Builder builder = new Request.Builder();
        builder.url(url);//请求的路径
        Request request = builder.get().build();//生成请求对象


        //发起一次网络请求
        Call call = client.newCall(request);//client为请求的客户端

        try {
            Response res = call.execute();
            return Objects.requireNonNull(res.body()).string();
        } catch (IOException e) {
            return null;
        }
    }

    public static String wrPOST(String url, Map<String, String> content) {
        //添加请求的参数
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (String key : content.keySet()) {
            formBodyBuilder.add(key, content.get(key));//添加参数,多次调用add函数，添加多个参数
        }
        //生成请求的对象
        //先创建builder对象，通过builder对象创建请求对象
        Request.Builder builder = new Request.Builder();
        builder.url(url);//请求的路径
        builder.post(formBodyBuilder.build());
        Request request = builder.build();//生成请求对象

        //发起一次网络请求
        Call call = client.newCall(request);//client为请求的客户端
        try {
            Response res = call.execute();
            return res.body().string();
        } catch (IOException e) {
            return null;
        }
    }

    public static String wrPOST_JSON(String url, Map<String, String> parameter, String content) {
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        if (parameter != null && !content.isEmpty()) {
            sb.append("?");
            for (String key : parameter.keySet()) {
                sb.append(key + "=" + parameter.get(key) + "&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        url = sb.toString();
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), content);

        //生成请求的对象
        //先创建builder对象，通过builder对象创建请求对象
        Request.Builder builder = new Request.Builder();
        builder.url(url);//请求的路径
        builder.post(requestBody);
        Request request = builder.build();//生成请求对象

        //发起一次网络请求
        Call call = client.newCall(request);//client为请求的客户端
        try {
            Response res = call.execute();
            return Objects.requireNonNull(res.body()).string();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 内容敏感词检测
     *
     * @param content
     * @return
     */
    public static ContentValidate checkContent(String content) {

        //1.获取access token
        final String accessToken = WXAPPInfo.getAccess_token();
        if (accessToken == null) {
            return ContentValidate.TOKE_FAIL;
        }
        //2.构造请求头，参数，检测敏感词
        Map<String, String> parameter = new LinkedHashMap<>();
        parameter.put("access_token", accessToken);
        JSONObject header = new JSONObject();
        header.put("content", content);
        String response = wrPOST_JSON("https://api.weixin.qq.com/wxa/msg_sec_check", parameter, header.toJSONString());
        JSONObject object = WXAPPInfo.isJSON(response);
        //向微信服务端申请出现异常
        if (object == null) {
            return ContentValidate.ERROR;
        }
        //内容不合格
        if (!"ok".equals(object.getString("errmsg"))) {
           return ContentValidate.SENSITIVE;
        }
        //通过
        return ContentValidate.PASS;
    }
}