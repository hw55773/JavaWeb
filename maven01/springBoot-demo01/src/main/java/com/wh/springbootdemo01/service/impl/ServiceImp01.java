package com.wh.springbootdemo01.service.impl;

import com.wh.springbootdemo01.Pojo.User;
import com.wh.springbootdemo01.dao.Mapper;
import com.wh.springbootdemo01.dao.impl.Mapper01;
import com.wh.springbootdemo01.service.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * className:       serviceImp01
 * author:          wenhao2002
 * date:            2024/4/6 20:22
 */
//@Component//将当前类交给IOC容器管理，成为IOC容器中的bean;
@Service(value = "s01")//@Component的衍生注解
public class ServiceImp01 implements ServiceImp {


    @Autowired//运行是IOC会提供该类型的bean对象，并赋值给该变量--依赖注入
    private Mapper mapper ;


    @Override
    public User method() {
        User user= mapper.method();
       if (user.getAddress().getCity().equals("广元")){
           user.getAddress().setCity("成都");
       }

        return user;
    }
}
