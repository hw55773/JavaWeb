package com.kxdk.mapper;

import com.kxdk.pojo.Depte;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * interfaceName:       depteMapper
 * author:            wenhao2002
 * date:               2024/4/26 21:12
 */
@Mapper
public interface DepteMapper {

    @Select("select * from tb_depte")
    public List<Depte> depteList();
}
