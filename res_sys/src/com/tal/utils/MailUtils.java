package com.tal.utils;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * 邮件发送的工具类
 * @author admin
 *
 */
public class MailUtils {

	/**
	 * 发送邮件的工具方法
	 * @param address 收件人地址
	 * @param title 邮件标题
	 * @param content 内容
	 */
	public static void sendMail( String address , String title , String content ){
		// Session对象:
		Properties props = new Properties();
		
		props.setProperty("smtp.host", "127.0.0.1");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("admin@mingde.com", "admin");
			}
			
		});
		// Message对象:
		Message message = new MimeMessage(session);
		// 设置发件人：
		try {
			message.setFrom(new InternetAddress("admin@mingde.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress( address ));
			// 设置主题:
			message.setSubject( title );
			// 设置内容：
			message.setContent(content,"text/html;charset=UTF-8");
			// Transport对象:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		sendMail("user001@mingde.com","测试邮件001","abc123这是测试邮件");
	}
}