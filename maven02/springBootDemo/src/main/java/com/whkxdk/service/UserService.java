package com.whkxdk.service;

import com.whkxdk.pojo.PageBean;
import com.whkxdk.pojo.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * interfaceName:       UserService
 * author:            wenhao2002
 * date:               2024/5/1 19:26
 */
public interface UserService {
    PageBean page(Integer page, Integer pageSize, String name, LocalDateTime begin, LocalDateTime end);//分页获取用户数据

    void deleteUsers(List<Integer> ids);//批量删除员工

    void addUser(User user);//添加员工

    User getUserDetiles(Integer id);//员工详情

    void update(User user);//更新员工

    User login(User user);//员工登录
}
