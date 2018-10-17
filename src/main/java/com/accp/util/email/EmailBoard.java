package com.accp.util.email;

/**
 * 邮件模板
 * 
 * @author yuno
 *
 */
public class EmailBoard {
	/**
	 * 注册邮件模板
	 * 
	 * @param name
	 *            用户昵称
	 * @param url
	 *            注册地址
	 * @return 模板
	 */
	public static String register(String name, String url) {
		return "<div style='width:700px;height:516px;margin:0 auto;background:#fff;text-align:center;'>\r\n"
				+ "	<div style='text-align:left;'><img src='http://www.yphting.com/Public/images/email_logo.png' height='114' width='220'></div>\r\n"
				+ "	<div style='padding:0 120px;'>\r\n"
				+ "		<h1 style='font-size:30px;line-height:40px;font-weight:normal;'>Hi, " + name + "</h1>\r\n"
				+ "		<p style='font-size:16px;'>欢迎注册御品韩汀，点击以下链接验证您的邮箱</p>\r\n" + "		<a href='" + url
				+ "' style='background: #f34295;margin:15px 0;display:inline-block; padding:10px 70px;border-radius:30px;color:#fff;text-decoration:none;font-size:16px;letter-spacing:4px;' rel='noopener' target='_blank'>确认电子邮箱地址</a>\r\n"
				+ "		<p>如您无法点击上述链接，可将如下地址复制到浏览器后打开：<br>\r\n" + "			<a href='" + url
				+ "' style='color: #201e5d;display:inline-block;text-decoration:none;line-height:32px;' rel='noopener' target='_blank'>"
				+ url + "</a>\r\n" + "		</p>\r\n" + "	</div>\r\n" + "</div>";
	}

	/**
	 * 验证码邮件模板
	 * 
	 * @param name
	 *            用户昵称
	 * @param info
	 *            提示语
	 * @param code
	 *            验证码
	 * @return 模板
	 */
	public static String verifyCode(String name, String info, String code) {
		return "<div style='width:700px;height:516px;margin:0 auto;background:#fff;text-align:center;'>\r\n"
				+ "	<div style='text-align:left;'><img src='http://www.yphting.com/Public/images/email_logo.png' height='114' width='220'></div>\r\n"
				+ "	<div style='padding:0 120px;'>\r\n"
				+ "		<h1 style='font-size:30px;line-height:40px;font-weight:normal;'>Hi, " + name + "</h1>\r\n"
				+ "		<p style='font-size:16px;'>" + info + "</p>\r\n"
				+ "		<span style='background: #f34295;margin:15px 0;display:inline-block; padding:10px 70px;border-radius:30px;color:#fff;text-decoration:none;font-size:16px;letter-spacing:4px;'>"
				+ code + "</span>\r\n" + "	</div>\r\n" + "</div>";
	}
}