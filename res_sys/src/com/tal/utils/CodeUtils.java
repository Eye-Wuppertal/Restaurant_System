package com.tal.utils;


import Decoder.BASE64Encoder;

import java.security.MessageDigest;
import java.util.UUID;

public class CodeUtils {

	//MD5加密工具方法(MD5摘要算法，把任意长度的字符串算成一个唯一的24位长的字符串)
	public static String md5(String str) {
		MessageDigest md5;
		String newstr = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return newstr;
	}

	//生成32位随机字符串做ID
	public static String generateId(){
		//生成的UUID字符串是36位长，字段长度是32位，需要去掉生成的字符串中的四个“-”
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	//生成64位激活码
	public static String generateCode(){
		return generateId()+generateId();
	}


}
