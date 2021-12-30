package com.tal.service.impl;

import com.tal.domain.User;
import com.tal.mapper.UserMapper;
import com.tal.service.UserService;
import com.tal.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//�û����ҵ���ʵ����
@Service("userService")//��ע��ҵ���߼���Ķ��������
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;//��Spring������ɶ���ע��
	
	//ע���û�
	@Override
	public void registUser(User user) {
		
		user.setPassword( CodeUtils.md5( user.getPassword() ) );//��������в��������
		user.setUid( CodeUtils.generateId() );//����һ�������32λ�ַ�����Ϊ�û�������ID

		//���û������з�װ����Ϣд�뵽���ݿ����
		userMapper.insertUser(user);
		
	}


	/*��¼��֤
	 * username:�û���
	 * password:����
	 * ����ֵ��User����
	 * 		��¼�ɹ����򷵻ص�¼���û��Ķ���
	 * 		��¼ʧ�ܣ��򷵻�null
	 */
	@Override
	public User checkLogin(String username, String password) {
		User result = null;
		
		//�����û����������ݿ���ȡ����Ӧ�û��Ķ���
		User user = userMapper.findByUsername(username);
		
		//�жϴ˶����Ƿ�Ϊ�գ����Ϊ�գ�˵�����û���������
		if( user != null ){
			//�����Ƿ�����ݿ���б��������һ�£����û�״̬Ϊ���Ѽ����ע���ύ��������Ҫ�ȼ����ٺ����ݿ��е�������бȶ�
			if( user.getPassword().equals( CodeUtils.md5(password) )){
				result = user;//�û����ڣ�������ȷ��״̬��ȷ���򷵻ش˶���
			}
		}
		
		return result;
	}
	
	

}
