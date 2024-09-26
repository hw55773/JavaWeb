package com.whkxdk.mapper;

import com.whkxdk.pojo.Depte;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * interfaceName:       DepteMapper
 * author:            wenhao2002
 * date:               2024/4/28 17:32
 */
@Mapper
public interface DepteMapper {

    @Select("select * from tb_depte")
    List<Depte> getDepteListInfo();//获取所有员工信息

    @Delete("delete from tb_depte where id=#{id}")//根据id删除部门  &同时删除所员工
    void deleteById(Integer id);

    void insertDepte(Depte depte);//添加部门

    @Select("select * from tb_depte where id=#{id}")
    Depte getDepteById(Integer id);//根据id查询部门

    void updateDepte(Depte depte);//修改部门信息

}
