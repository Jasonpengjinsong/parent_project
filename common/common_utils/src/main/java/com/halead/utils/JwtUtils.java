package com.halead.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @title: JwtUtils
 * @Author ppjjss
 * @Date: 2022/7/24 19:51
 * @Version 1.0
 */

public class JwtUtils {

    public static final long EXPIRE = 1000*60*60*24;
    public static final String APP_SECRET = "";

    //生成token字符串
    public static String getJwtToken(String id ,String nickname){
        String JwtToken = Jwts.builder().setHeaderParam("type", "JWT").setHeaderParam("alg", "HS256")
                .setSubject("pjs-user").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()))
                .claim("id", id).claim("nickname", nickname)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken){
        if(StringUtils.isEmpty(jwtToken)){
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
           return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request){

        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)){
                return false;
            }
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getMemberIdByJwtToken(HttpServletRequest request) {

        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)){
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("id");
    }
}
