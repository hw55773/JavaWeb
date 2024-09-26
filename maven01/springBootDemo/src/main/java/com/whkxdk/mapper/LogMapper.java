package com.whkxdk.mapper;

import com.whkxdk.pojo.DepteLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * interfaceName:       LogMapper
 * author:            wenhao2002
 * date:               2024/5/10 22:23
 */
@Mapper
public interface LogMapper {

    /*
    *propagation属性默认为Propagation.REQUIRES 需要事务，有则加入，无则创建新事务
    * Propagation.REQUIRES_NEW 需要新事物，无论有无,总是创建新事物,挂起旧事务,新事务执行完后，继续执行旧事务
    * */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    void insert(DepteLog depteLog);
}
