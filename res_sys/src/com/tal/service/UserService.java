package com.tal.service;

import com.tal.domain.User;

public interface UserService {
	//业务逻辑的添加用户（注册用户）的方法
	void registUser( User user );
	
	//激活用户
	void activeUser( String code );
	
	//登录验证
	User checkLogin( String username , String password );

}
