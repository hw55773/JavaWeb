package com.wh.springbootdemo01.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wh.springbootdemo01.Pojo.Address;
import com.wh.springbootdemo01.Pojo.Result;
import com.wh.springbootdemo01.Pojo.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class HelloController {

    //没有统一返回结果
    /*//原始方法
    @RequestMapping("/simpleParent")
    public String simpleParen1(HttpServletRequest request){
           //获取请求参数
        String name=request.getParameter("name");
        String ageStr=request.getParameter("age");
        int age=Integer.parseInt(ageStr);
        System.out.println(name+":"+age);
        return name+":"+age;//返回字符串
    }
    //springBoot方式
    @RequestMapping("/Parent1")
    //public String simpleParen2(String name, Integer age){
    //@RequestParam(name = "name") String username如果与请求映射名不一致需要用这个注解
    public String simpleParen2(@RequestParam(name = "name") String username, Integer age){
        System.out.println(username+"::"+age);

        return username+":"+age;//返回字符串
    }
    //封装简单参数
    @RequestMapping("/Parent2")
    public String simpleParen3(User user){
        System.out.println(user.getName()+"::"+user.getAge());
        System.out.println(user);

        return "OK3";
    }
    //封装复杂参数
    @RequestMapping("/Parent3")
    public User simpleParen4(User user){
        System.out.println(user.getName()+"::"+user.getAge()+"::"+user.getAddress());
        System.out.println(user);

        return user;//返回json 格式数据
    }
    //数组参数
    @RequestMapping("/arryParames")
    public String arryParames(String[] hooby){
        System.out.println(Arrays.toString(hooby));

        return "OK5";
    }
    //集合参数
    @RequestMapping("/listParames")
    //默认式数组类型血药@RequestParam注解映射
    public String listParames(@RequestParam List<String> hooby){
        System.out.println(hooby);
        return "OK6";
    }
    //日期参数
    @RequestMapping("/dataParames")
    public String dataParames(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);

        return "OK7";
    }
    //json参数
    @RequestMapping("/jsonParames")
    public String jsonParames(@RequestBody User user){
        System.out.println(user);

        return "OK8";
    }
    //路径参数
    //注解@PathVariable用来获取接受路径参数id和name
    @RequestMapping("/pathParames/{id}/{name}")
    public String pathParames(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+":"+name);

        return "OK9";
    }
    //返回列表信息
    @RequestMapping("/listUser")
    public List<User> list(){
        List<User> listUser=new ArrayList<User>();
        User user1=new User();
        Address address1=new Address();
        address1.setCity("成都");
        address1.setProvince("四川");
        user1.setName("Wh");
        user1.setAge(12);
        user1.setAddress(address1);
        User user2=new User();
        Address address2=new Address();
        address2.setCity("广元");
        address2.setProvince("四川");
        user2.setName("Wh");
        user2.setAge(12);
        user2.setAddress(address2);
        listUser.add(user1);
        listUser.add(user2);
        return listUser;
    }
    //入门程序
    @RequestMapping("/hello")
    public String HelloWorld(){
        System.out.println("Hello SpringBoot");
        return "Hello SpringBoot";
    }*/

    //统一的返回结果
    //原始方法
    @RequestMapping("/simpleParent")
    public Result simpleParen1(HttpServletRequest request){
        //获取请求参数
        String name=request.getParameter("name");
        String ageStr=request.getParameter("age");
        int age=Integer.parseInt(ageStr);
        System.out.println(name+":"+age);
        String data=name+":"+age;
        return Result.success(data);//返回字符串
    }
    //springBoot方式
    @RequestMapping("/Parent1")
    //public String simpleParen2(String name, Integer age){
    //@RequestParam(name = "name") String username如果与请求映射名不一致需要用这个注解
    public Result simpleParen2(@RequestParam(name = "name") String username, Integer age){
        System.out.println(username+"::"+age);
        String data=username+":"+age;
        return Result.success(data);//返回字符串
    }
    //封装简单参数
    @RequestMapping("/Parent2")
    public Result simpleParen3(User user){
        System.out.println(user.getName()+"::"+user.getAge());
        System.out.println(user);

        return Result.success(user);
    }
    //封装复杂参数
    @RequestMapping("/Parent3")
    public Result simpleParen4(User user){
        System.out.println(user.getName()+"::"+user.getAge()+"::"+user.getAddress());
        System.out.println(user);

        return Result.success(user);//返回json 格式数据
    }
    //数组参数
    @RequestMapping("/arryParames")
    public Result arryParames(String[] hooby){
        System.out.println(Arrays.toString(hooby));

        return Result.success(hooby);
    }
    //集合参数
    @RequestMapping("/listParames")
    //默认式数组类型要写@RequestParam注解映射
    public Result listParames(@RequestParam List<String> hooby){
        System.out.println(hooby);
        return Result.success(hooby);
    }
    //日期参数
    @RequestMapping("/dataParames")
    public Result dataParames(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        String format = updateTime.format(formatter);
        return Result.success(updateTime);
    }
    //json参数
    @RequestMapping("/jsonParames")
    public Result jsonParames(@RequestBody User user){
        System.out.println(user);

        return Result.success(user);
    }
    //路径参数
    //注解@PathVariable用来获取接受路径参数id和name
    @RequestMapping("/pathParames/{id}/{name}")
    public Result pathParames(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+":"+name);
        String data=id+":"+name;

        return Result.success(data);
    }
    //返回列表信息
    @RequestMapping("/listUser")
    public Result list(){
        List<User> listUser=new ArrayList<User>();
        User user1=new User();
        Address address1=new Address();
        address1.setCity("成都");
        address1.setProvince("四川");
        user1.setName("Wh");
        user1.setAge(12);
        user1.setAddress(address1);
        User user2=new User();
        Address address2=new Address();
        address2.setCity("广元");
        address2.setProvince("四川");
        user2.setName("Wh");
        user2.setAge(12);
        user2.setAddress(address2);
        listUser.add(user1);
        listUser.add(user2);
        return Result.success(listUser);
    }
    //入门程序
    @RequestMapping("/hello")
    public Result HelloWorld(){
        System.out.println("Hello SpringBoot");
        return Result.success("Hello SpringBoot");
    }
}
