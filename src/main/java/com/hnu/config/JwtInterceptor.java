package com.hnu.config;

import com.alibaba.fastjson.JSONObject;
import com.hnu.utils.AppJWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+":");
        System.out.println("拦截器执行");
        System.out.println("拦截路径:"+request.getRequestURL());
        JSONObject back = null;
        // 判断是否登陆逻辑
        //true 放行，false 拦截
        //检查请求头是否含有token
        String token = request.getHeader("token");
        System.out.println("token:"+token);
        if(token == null || "".equals(token)){
            System.out.println("验证token失败:"+"没有token");
            try{
                back = new JSONObject();
                back.put("msg", "没有令牌");
                back.put("status_code", "401");
                response.getOutputStream().write(back.toJSONString().getBytes());
            }catch (IOException|RuntimeException e){

            }
            return false;
        }
        //检查token的有效性
        if(!AppJWTUtil.verifyToken(token, AppJWTUtil.sec)){
            System.out.println("验证token失败:"+"token失效或者错误");
            try {
                back = new JSONObject();
                back.put("msg", "令牌错误");
                back.put("status_code", "401");
                response.getOutputStream().write(back.toJSONString().getBytes());
            }catch (IOException|RuntimeException e){

            }
            return false;
        }
        System.out.println("验证token成功:");
        return true;
    }

}
