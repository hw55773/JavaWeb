package com.wh.mapper;

import com.wh.pojo.Depte;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * interfaceName:       DepteMapper
 * author:            wenhao2002
 * date:               2024/4/27 15:11
 */
@Mapper
public interface DepteMapper {

    //删除末尾行
    @Delete("delete from tb_depte where id=#{id}")
    public void deletDepte(Integer id);

    //插入数据
    @Options(useGeneratedKeys = true,keyProperty = "id")//主键返回
//    @Insert("Insert INTO tb_depte(depte_name, cagrotery, create_time, update_time) " +
//            "values(#{depteName},#{cagrotery},#{createTime},#{updateTime}) ")
    public void insertDepte(Depte depte);

    //更新数据
    public void updateDepte(Depte depte);

    //根据Id查询数据
    //方案三，在application.properties文件中配置开启驼峰命名映射
    @Select("select * from tb_depte where id=#{id}")
    public Depte search(Integer id);
    //方案一，起别名
//    @Select("select id, depte_name depteName, cagrotery, " +
//            "create_time createTime, update_time updateTime from tb_depte where id=#{id}")
//    public Depte search(Integer id);
    //方案二，使用@Results注解
//    @Results({
//            @Result(column = "depte_name",property = "depteName"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
//    @Select("select * from tb_depte where id=#{id}")
//    public Depte search(Integer id);
    //条件查询
    //不安全会有注入sql注入风险
//    @Select("select *from tb_depte where " +
//            "depte_name like '%${name}%' and create_time between #{begin} and #{end} and cagrotery =#{cagrotery} " +
//            "order by update_time desc ")
//    public List<Depte> searchOrder(String name, String cagrotery, LocalDate begin, LocalDate end);

    public List<Depte> searchOrder(@Param("nam") String name, String cagrotery, LocalDate begin, LocalDate end);//@Param注解相当于起别名

    //动态删除多个行根据id
    public void deleteList(List<Integer> ids);
}
