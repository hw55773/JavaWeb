package com.whkxdk.controller;

import com.whkxdk.anonation.Log;
import com.whkxdk.pojo.Depte;
import com.whkxdk.pojo.Result;
import com.whkxdk.service.DepteService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * className:       DepteController
 * author:          wenhao2002
 * date:            2024/4/28 17:13
 */
@Slf4j
@RequestMapping("/deptes")
@RestController
public class DepteController {

    @Resource(name = "depteServiceImpl")
    DepteService depteService;


    //@RequestMapping(value = "/depteList",method = RequestMethod.GET)
    @GetMapping("/depteList")//查询所有部门
    public Result depteList(){

     List<Depte> depteList= depteService.getDepteListInfo();

     log.info("查询所有员工信息");
        return Result.success(depteList);
    }

    @Log
    @DeleteMapping("/depteDelete/{id}")//根据id删除部门
    public Result deleteDepte(@PathVariable Integer id){
        log.info("删除部门id：{}",id);
        depteService.deleteById(id);
        return Result.success();
    }

    @Log
    @PostMapping("/addDepte")//添加部门
    public Result addDepte(@RequestBody Depte depte){
    log.info("添加时间前部门信息: {}",depte);
        depteService.addDepete(depte);
        return Result.success();
    }

    @GetMapping("/depteById")//根据id查询部门
    public Result searchDepte(Integer id){

        log.info("根据id查询部门：{}",id);
        Depte depte=depteService.getDepteById(id);
        return Result.success(depte);
    }

    @Log
    @PutMapping("/updateDepte")//修改部门信息
    public Result update(@RequestBody Depte depte){
        log.info("添加时间前的更新的信息 {}",depte);
        depteService.updateDepte(depte);
        return Result.success();
    }
}
