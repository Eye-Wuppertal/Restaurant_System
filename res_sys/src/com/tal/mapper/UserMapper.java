package com.tal.mapper;

import com.tal.domain.User;

//用户表的Mapper接口
public interface UserMapper {

    void insertUser( User user );

    void activeUser( String code );

    User findByUsername( String username );
}
