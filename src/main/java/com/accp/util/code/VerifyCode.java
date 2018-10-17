package com.accp.util.code;

import java.util.Random;

/**
 * 验证码
 * 
 * @author yuno
 *
 */
public class VerifyCode {
	/**
	 * 生成验证码
	 * 
	 * @param length
	 *            长度
	 * @return 验证码
	 */
	public static String createVerifyCode(int length) {
		String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		String code = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			code += array[random.nextInt(array.length)];
		}
		return code;
	}
}