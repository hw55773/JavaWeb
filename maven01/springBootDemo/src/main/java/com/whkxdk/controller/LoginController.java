package com.whkxdk.controller;

import com.whkxdk.pojo.Result;
import com.whkxdk.pojo.User;
import com.whkxdk.service.UserService;
import com.whkxdk.utils.JwtUtiles;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * className:       LoginController
 * author:          wenhao2002
 * date:            2024/5/8 20:45
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public Result login(@RequestBody User user){
        log.info("登录员工信息 {}",user);
       User user1=userService.login(user);
if (user1!=null){
    Map<String, Object> claims=new HashMap<>();
    claims.put("id",user1.getId());
    claims.put("userName",user1.getUserName());
    claims.put("password",user1.getUserPassword());
    claims.put("avatar",user1.getAvatar());
    claims.put("depteId",user1.getDepteId());
   String token=JwtUtiles.jwtCreate(claims,2L);
    return Result.success(token);
}


        return Result.error("用户名或密码错误");
    }
}
