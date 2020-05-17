package com.hnu.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppJWTUtil {


    public static String sec ="yi2uC85p-OyrTePSoYdnVn2gA8RWtBsn5BnEIFi_5G4";//密钥
    /**
     *
     * @param content 用户名
     * @param day 过期天数，大于0
     * @param hour 过期小时，0到23
     * @param minute 过期分钟，0到5
     * @return 得到的token(令牌)
     */
    public static String createToken(String content, int day, int hour, int minute, String key){

        if(day<0||hour<0||minute<0||hour>23||minute>59){
            return null;
        }
        Algorithm algorithm = Algorithm.HMAC256(key);
        Map<String,Object> header =new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.getTime());
        calendar.add(Calendar.DAY_OF_YEAR,day);
        calendar.add(Calendar.HOUR_OF_DAY,hour);
        calendar.add(Calendar.MINUTE,minute);

        String token = com.auth0.jwt.JWT.create().withHeader(header)
                .withClaim("content",content)
                .withIssuedAt(now)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
        return token;
    }

    /**
     *
     * @param token 待验证的token(令牌)
     * @return true 验证通过，false验证失败
     */
    public static boolean verifyToken(String token,String key){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
