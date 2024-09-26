package com.whkxdk.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
/**
 * className:       JwtUtiles
 * author:          wenhao2002
 * date:            2024/5/9 9:16
 */

public class JwtUtiles {

    private static final String key = "kxdk"; // 密钥需要保密，并且应该是一个安全的随机字符串

    // 生成Jwt
    public static String jwtCreate(Map<String, Object> claims, Long time) {
        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .setExpiration(new Date(System.currentTimeMillis() + time * 3600 * 1000))
                .compact();
        return jwt;
    }

    // 校验jwt
    public static Claims jwtValidate(String token) {
        try {
            // 如果解析成功，说明令牌未过期且签名正确
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // 解析失败，可能是令牌过期、签名不正确或其他问题
            // 这里可以记录异常或进行其他处理
            return null;
        }
    }

//    // 如果需要校验特定的声明（如用户ID），可以添加额外的逻辑
//    // 例如，校验用户ID是否匹配
//    public static boolean jwtValidateWithUserId(String token, String userId) {
//        try {
//            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
//            String userIdFromToken = (String) claims.get("userId"); // 假设userId是存储在JWT中的一个声明
//            return userIdFromToken != null && userIdFromToken.equals(userId);
//        } catch (Exception e) {
//            // 解析失败或用户ID不匹配
//            return false;
//        }
//    }
}