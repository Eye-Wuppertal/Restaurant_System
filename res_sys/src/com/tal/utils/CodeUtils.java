package com.tal.utils;


import Decoder.BASE64Encoder;

import java.security.MessageDigest;
import java.util.UUID;

public class CodeUtils {

	//MD5���ܹ��߷���(MD5ժҪ�㷨�������ⳤ�ȵ��ַ������һ��Ψһ��24λ�����ַ���)
	public static String md5(String str) {
		MessageDigest md5;
		String newstr = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //���ܺ���ַ���
	        newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return newstr;
	}

	//����32λ����ַ�����ID
	public static String generateId(){
		//���ɵ�UUID�ַ�����36λ�����ֶγ�����32λ����Ҫȥ�����ɵ��ַ����е��ĸ���-��
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	//����64λ������
	public static String generateCode(){
		return generateId()+generateId();
	}


}
