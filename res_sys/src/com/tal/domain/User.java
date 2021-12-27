package com.tal.domain;

import java.util.Date;

/*
 * CREATE TABLE `tb_user` (
  `uid` VARCHAR(32) PRIMARY KEY,
  `username` VARCHAR(20) UNIQUE,
  `password` VARCHAR(24) DEFAULT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `email` VARCHAR(30) DEFAULT NULL,
  `telephone` VARCHAR(20) DEFAULT NULL,
  `birthday` DATE DEFAULT NULL,
  `sex` VARCHAR(1) DEFAULT NULL,
  `state` INT(1) DEFAULT NULL,
  `code` VARCHAR(64) DEFAULT NULL
);
 */
//�û�ʵ����
public class User {
	
	/*
	 * �Ѽ���״̬ 
	 */
	public static final int USER_STATE_ACTIVE = 1;

	/*
	 * δ����״̬ 
	 */
	public static final int USER_STATE_UNACTIVE = 0;
	
	
	private String uid;			//�û�ID
	private String username;	//�û�����Ψһ��
	private String password;	//����
	private String name;		//����
	private String email;		//��������
	private String telephone;	//�绰
	private Date birthday;		//����
	private String sex;			//�Ա�
	private int state=0;		//״̬��0��δ��� 1���Ѽ��
	private String code;		//������

	public User(){}

	public User(String uid, String username, String password, String name, String email, String telephone,
			Date birthday, String sex, int state, String code) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.sex = sex;
		this.state = state;
		this.code = code;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static int getUserStateActive() {
		return USER_STATE_ACTIVE;
	}

	public static int getUserStateUnactive() {
		return USER_STATE_UNACTIVE;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", birthday=" + birthday + ", sex=" + sex + ", state=" + state
				+ ", code=" + code + "]";
	}
	
	
	
}
