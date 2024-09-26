package com.wh.springbootdemo01.dao.impl;

import com.wh.springbootdemo01.Pojo.Address;
import com.wh.springbootdemo01.Pojo.User;
import com.wh.springbootdemo01.dao.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * className:       Mapper01
 * author:          wenhao2002
 * date:            2024/4/6 20:09
 */
//@Component//将当前类交给IOC容器管理，成为IOC容器中的bean;
@Repository//@Component的衍生注解
public class Mapper01 implements Mapper {
    @Override
    public User method() {

        return new User("文豪",22,new Address("四川","广元"));
    }
}
