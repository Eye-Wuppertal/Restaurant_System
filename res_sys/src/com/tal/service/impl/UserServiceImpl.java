package com.tal.service.impl;

import com.tal.domain.User;
import com.tal.mapper.UserMapper;
import com.tal.service.UserService;
import com.tal.utils.CodeUtils;
import com.tal.utils.MailUtils;
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
		user.setCode( CodeUtils.generateCode() );//�����룬����32λ�ַ���ƴ�ӳ�һ��64λ������
		
		//���û������з�װ����Ϣд�뵽���ݿ����
		userMapper.insertUser(user);
		
		String address = user.getEmail();
		String title = "�����̳��û������ʼ�";
		String content = user.getName() + (user.getSex().equals("��")?"����":"Ůʿ") + "���ã���ϲ��ע��ɹ������������ӽ��м��"
				+"<a href='http://127.0.0.1:8088/estore/active?code="+user.getCode()+"'>�����˻�</a>";
		//���ͼ����ʼ�
		MailUtils.sendMail( address , title , content);
		
	}

	//�����û�
	@Override
	public void activeUser(String code) {
		//����Mapper���޸����ݿ��
		userMapper.activeUser(code);
		
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
			if( user.getPassword().equals( CodeUtils.md5(password) ) && user.getState() == User.USER_STATE_ACTIVE ){
				result = user;//�û����ڣ�������ȷ��״̬��ȷ���򷵻ش˶���
			}
		}
		
		return result;
	}
	
	

}
