package com.whkxdk.controller;

import com.whkxdk.pojo.PageBean;
import com.whkxdk.pojo.Result;
import com.whkxdk.pojo.User;
import com.whkxdk.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * className:       UserController
 * author:          wenhao2002
 * date:            2024/4/28 17:13
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @GetMapping("/userList")//分页获取用户数据
    public Result pageBean(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "3") Integer pageSize,
                           String name,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") LocalDateTime begin,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") LocalDateTime end) {
        log.info("分页查询：{} {} {} {} {}", page, pageSize,name,begin,end);
        PageBean pageBean = userService.page(page, pageSize,name,begin,end);
        return Result.success(pageBean);
    }
    @DeleteMapping("/deleteUsers/{ids}")//批量删除员工
    public  Result deleteUsers(@PathVariable List<Integer> ids){
        log.info("批量删除员工 {}",ids);
        userService.deleteUsers(ids);
        return Result.success();
    }

    @PostMapping("/addUser")//添加员工
    public Result addUser(@RequestBody User user){

        log.info("新增员工信息 {}",user);
        userService.addUser(user);

        return  Result.success();
    }
    @GetMapping("/userDetiles/{id}")//用户详情
    public Result userDetiles(@PathVariable Integer id){
        log.info("用户id,{}",id);
         User user= userService.getUserDetiles(id);
       return Result.success(user);
    }
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user){

        log.info("更新用户信息 {}",user);
        userService.update(user);
      return  Result.success();
    }
}
