package com.whkxdk.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.whkxdk.mapper.UserMapper;
import com.whkxdk.pojo.PageBean;
import com.whkxdk.pojo.User;
import com.whkxdk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * className:       UserServiceImpl
 * author:          wenhao2002
 * date:            2024/5/1 19:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /*    @Override//分页获取用户数据
        public PageBean page(Integer page, Integer pageSize) {

            List<User> userList = userMapper.pageList((page - 1) * pageSize, pageSize);
            Long count = userMapper.count();

            return new PageBean(count, userList);
        }*/
    @Override//分页获取用户数据
    public PageBean page(Integer page, Integer pageSize, String name, LocalDateTime begin, LocalDateTime end) {
        PageHelper.startPage(page, pageSize);
        List<User> userList = userMapper.userList(name,begin,end);
        Page<User> p = (Page<User>) userList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override//批量删除员工
    public void deleteUsers(List<Integer> ids) {
        userMapper.deleteUser(ids);
    }

    @Override//添加员工
    public void addUser(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertUser(user);
    }

    @Override
    public User getUserDetiles(Integer id) {

        return userMapper.getUserDetiles(id);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public User login(User user) {
        return userMapper.getUserByUserNameAndUserpassword(user);
    }
}
