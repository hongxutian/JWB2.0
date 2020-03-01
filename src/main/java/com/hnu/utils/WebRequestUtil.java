package com.hnu.utils;


import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class WebRequestUtil {

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
        builder.post(formBodyBuilder.build());
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


}