package com.tal.service;

import com.tal.domain.User;

public interface UserService {
	//ҵ���߼�������û���ע���û����ķ���
	void registUser( User user );
	
	//��¼��֤
	User checkLogin( String username , String password );

}
