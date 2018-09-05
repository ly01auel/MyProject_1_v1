package cn.com.lin.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

public class TestMail {
	@Test
	public void sendMail() throws MessagingException {
		// 穿件properties
		Properties prop = new Properties();
		prop.put("mail.transpot.protocol", "smtp");
		prop.put("mail.smtp.host", "localhost");
		prop.put("mail.smtp.port", 25);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.debug", "true");
		// 穿件邮件会话
		Session session = Session.getInstance(prop);
		session.setDebug(true);
		// 穿件邮件体对象(一封邮件对象)
		MimeMessage message = new MimeMessage(session);
		// 设置邮件参数

		// 标题
		message.setSubject("我的第一封邮件");
		// 发送时间
		message.setSentDate(new Date());
		// 发件人
		message.setFrom(new InternetAddress("lisi@itcast.com"));
		// 收件人
		message.setRecipient(RecipientType.TO, new InternetAddress("lisi@itcast.com"));

		// 邮件内容(纯文本)
		message.setText("Test 我的第一封邮件");
		// 保存邮件
		message.saveChanges();// 可选

		// 发送
		Transport trans = session.getTransport();
		trans.connect("lisi", "888");
		trans.sendMessage(message, message.getAllRecipients());
		trans.close();
	}

	@Test
	public void test() throws MessagingException {
		// 穿件properties
		Properties prop = new Properties();
		prop.put("mail.transpot.protocol", "smtp");
		prop.put("mail.smtp.host", "smtp.qq.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		// qq SSL认证
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");
		prop.put("mail.smtp.socketFactory.port", "465");

		Session session = Session.getInstance(prop);

		MimeMessage message = new MimeMessage(session);
		message.setSubject("我的第一封邮件", "utf-8");
		message.setFrom(new InternetAddress("1067147470@qq.com"));
		message.setSentDate(new Date());
		message.setContent("TEST", "text/html;charset=utf-8");
		message.setRecipient(RecipientType.TO, new InternetAddress("linff@jsciq.gov.cn"));
		message.saveChanges();

		Transport trans = session.getTransport();
		trans.connect("1067147470@qq.com", "spyqifyunuofbfhg");
		trans.sendMessage(message, message.getAllRecipients());
	}
}
