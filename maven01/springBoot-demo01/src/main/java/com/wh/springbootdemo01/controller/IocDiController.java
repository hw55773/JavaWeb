package com.wh.springbootdemo01.controller;

import com.wh.springbootdemo01.Pojo.Address;
import com.wh.springbootdemo01.Pojo.Result;
import com.wh.springbootdemo01.Pojo.User;
import com.wh.springbootdemo01.service.ServiceImp;
import com.wh.springbootdemo01.service.impl.ServiceImp01;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * className:       HelloController
 * author:          wenhao2002
 * date:            2024/3/31 21:49
 */
//请求处理类
@RestController
public class IocDiController {

    //@Qualifier("serviceImp02")//通过选择注入进的bean对象默认名称(类名首字母小写)选择注入,配合@Autowired使用；
    @Resource(name = "s01")//通过选择注入进的bean对象默认名称(类名首字母小写)选择注入,或者是自定义的名称；
    //@Autowired//运行是IOC会提供该类型的bean对象，并赋值给该变量--依赖注入
    ServiceImp service;

    @RequestMapping("/userInfo")
    public Result uerInfo(){


        return Result.success(service.method());


    }


}
