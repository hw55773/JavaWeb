package com.whkxdk.mapper;

import com.whkxdk.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * interfaceName:       UserMapper
 * author:            wenhao2002
 * date:               2024/4/28 17:33
 */
@Mapper
public interface UserMapper {


/*    //分页获取用户数据
    @Select("select * from `tb-user` limit #{index},#{pageSize}")
    public List<User> pageList(Integer index, Integer pageSize);

    //获取总数
    @Select("select count(*) from `tb-user`")
    public Long count();*/

    List<User> userList(String name, LocalDateTime begin,LocalDateTime end);//分页获取用户数据

    void deleteUser(List<Integer> ids);//批量删除员工

    void insertUser(User user);//添加员工

    @Select("select user_name, user_password, id, depte_id, create_time, update_time, avatar  from `tb-user` where id=#{id}" )
    User getUserDetiles(Integer id);

    void update(User user);

    User getUserByUserNameAndUserpassword(User user);
    @Delete("delete from `tb-user` where depte_id=#{id}")
    void  deleteDepteAndUser(Integer id);//根据id删除部门  &同时删除所员工
}
