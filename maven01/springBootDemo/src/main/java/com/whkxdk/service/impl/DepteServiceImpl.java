package com.whkxdk.service.impl;

import com.whkxdk.anonation.Myanonation;
import com.whkxdk.mapper.DepteMapper;
import com.whkxdk.mapper.LogMapper;
import com.whkxdk.mapper.UserMapper;
import com.whkxdk.pojo.Depte;
import com.whkxdk.pojo.DepteLog;
import com.whkxdk.service.DepteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * className:       DepteServiceImpl
 * author:          wenhao2002
 * date:            2024/5/1 19:27
 */
@Slf4j
@Service
public class DepteServiceImpl implements DepteService {


    @Autowired
   //@Resource(name = "depteMapper")
    DepteMapper depteMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    LogMapper logMapper;
    @Myanonation
    @Override//操作所有部门信息
    public List<Depte> getDepteListInfo() {

     List<Depte> depteList= depteMapper.getDepteListInfo();

        return depteList;
    }

    @Transactional(rollbackFor = Exception.class)//spring事务管理, 指定哪种进行事务管理，默认RuntimeException
    @Override//根据id删除部门
    public void deleteById(Integer id) {

        try {
            depteMapper.deleteById(id);//根据id删除部门  &同时删除所员工
//            int i=1/0;
            userMapper.deleteDepteAndUser(id);

        } finally {
//            DepteLog depteLog= new DepteLog();
//            depteLog.setOperateTime(LocalDateTime.now());
//            depteLog.setReturnValue("操作记录");
//            logMapper.insert(depteLog);
        }

    }

    @Override//添加部门
    public void addDepete(Depte depte) {
        depte.setCreateTime(LocalDateTime.now());
        depte.setUpdateTime(LocalDateTime.now());
        log.info("添加的部门信息:{}",depte);
        depteMapper.insertDepte(depte);
    }

    @Myanonation
    @Override//根据id查询部门
    public Depte getDepteById(Integer id) {

        return depteMapper.getDepteById(id);
    }

    @Override//修改部门信息
    public void updateDepte(Depte depte) {
        depte.setUpdateTime(LocalDateTime.now());
        log.info("更新的部门信息: {}",depte);
        depteMapper.updateDepte(depte);
    }
}
