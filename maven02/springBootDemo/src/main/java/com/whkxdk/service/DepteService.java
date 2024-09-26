package com.whkxdk.service;

import com.whkxdk.pojo.Depte;

import java.util.List;

/**
 * className:       DepteService
 * author:          wenhao2002
 * date:            2024/5/1 19:25
 */
public interface DepteService {

    List<Depte> getDepteListInfo();//查询所有部门信息

    void deleteById(Integer id);//根据id删除部门

    void addDepete(Depte depte);//添加部门

    Depte getDepteById(Integer id);//根据id查询部门

    void updateDepte(Depte depte);//修改部门信息
}
