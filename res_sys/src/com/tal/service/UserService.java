package com.tal.service;

import com.tal.domain.User;

public interface UserService {
	//ҵ���߼�������û���ע���û����ķ���
	void registUser( User user );
	
	//�����û�
	void activeUser( String code );
	
	//��¼��֤
	User checkLogin( String username , String password );

}
