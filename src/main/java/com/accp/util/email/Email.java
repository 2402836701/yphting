package com.accp.util.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * 邮件
 * 
 * @author yuno
 *
 */
public class Email {
	// 发件人
	private final static String NAME = "yphting@163.com";

	// 安全码
	private final static String PWD = "cop250646";

	// 发件人昵称
	private final static String NICK = "韩汀社区";

	/**
	 * 发送邮件
	 * 
	 * @param to
	 *            收件人
	 * @param title
	 *            标题
	 * @param text
	 *            内容
	 * @return 发送状态
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 * @throws AddressException
	 */
	public static void sendSimpleMail(String to, String title, String text)
			throws AddressException, UnsupportedEncodingException, MessagingException {
		Properties prop = new Properties();
		prop.put("mail.host", "smtp.163.com");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", true);
		Session session = Session.getInstance(prop);
		session.setDebug(true);
		Transport ts = session.getTransport();
		ts.connect(NAME, PWD);
		Message msg = createSimpleMail(session, to, title, text);
		ts.sendMessage(msg, msg.getAllRecipients());
	}

	/**
	 * 新建邮件
	 * 
	 * @param session
	 *            会话
	 * @param to
	 *            收件人
	 * @param title
	 *            标题
	 * @param text
	 *            内容
	 * @return 邮件
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public static MimeMessage createSimpleMail(Session session, String to, String title, String text)
			throws AddressException, MessagingException, UnsupportedEncodingException {
		MimeMessage mm = new MimeMessage(session);
		mm.setFrom(new InternetAddress(javax.mail.internet.MimeUtility.encodeText(NICK) + "<" + NAME + ">"));
		mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mm.setRecipients(Message.RecipientType.CC, InternetAddress.parse(NAME));
		mm.setSubject(title);
		mm.setContent(text, "text/html;charset=utf-8");
		return mm;
	}
}