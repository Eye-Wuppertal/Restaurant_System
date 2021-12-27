package com.tal.service.impl;

import com.tal.domain.User;
import com.tal.mapper.UserMapper;
import com.tal.service.UserService;
import com.tal.utils.CodeUtils;
import com.tal.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用户相关业务的实现类
@Service("userService")//标注此业务逻辑类的对象的名字
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;//由Spring框架生成对象并注入
	
	//注册用户
	@Override
	public void registUser(User user) {
		
		user.setPassword( CodeUtils.md5( user.getPassword() ) );//对密码进行不可逆加密
		user.setUid( CodeUtils.generateId() );//生成一个随机的32位字符串做为用户的主键ID
		user.setCode( CodeUtils.generateCode() );//激活码，两个32位字符串拼接成一个64位激活码
		
		//把用户对象中封装的信息写入到数据库表中
		userMapper.insertUser(user);
		
		String address = user.getEmail();
		String title = "明德商城用户激活邮件";
		String content = user.getName() + (user.getSex().equals("男")?"先生":"女士") + "您好，恭喜您注册成功，请点击此链接进行激活："
				+"<a href='http://127.0.0.1:8088/estore/active?code="+user.getCode()+"'>激活账户</a>";
		//发送激活邮件
		MailUtils.sendMail( address , title , content);
		
	}

	//激活用户
	@Override
	public void activeUser(String code) {
		//调用Mapper，修改数据库表
		userMapper.activeUser(code);
		
	}

	/*登录验证
	 * username:用户名
	 * password:密码
	 * 返回值：User对象
	 * 		登录成功，则返回登录的用户的对象
	 * 		登录失败，则返回null
	 */
	@Override
	public User checkLogin(String username, String password) {
		User result = null;
		
		//根据用户名，从数据库中取得相应用户的对象
		User user = userMapper.findByUsername(username);
		
		//判断此对象是否为空，如果为空，说明此用户名不存在
		if( user != null ){
			//密码是否和数据库表中保存的密码一致，且用户状态为“已激活”，注意提交的密码需要先加密再和数据库中的密码进行比对
			if( user.getPassword().equals( CodeUtils.md5(password) ) && user.getState() == User.USER_STATE_ACTIVE ){
				result = user;//用户存在，密码正确，状态正确，则返回此对象
			}
		}
		
		return result;
	}
	
	

}
