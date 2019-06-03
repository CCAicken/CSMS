package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	/**
	 * 判断手机号码格式正确性
	 * @param mobile 手机号码
	 * @return true 正确，false 不正确
	 */
	public static boolean isMobile(String mobile){
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{4,8}$");
		m = p.matcher(mobile);
		b = m.matches();
		return b;
	}
	/**
	 * 判断普通电话号码格式正确性
	 * @param phoneCode 普通电话号码，可以是"010-52233298","4725666"
	 * @return true 正确，false 不正确
	 */
	public static boolean isPhone(String phoneCode){
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^0\\d{2,3}-\\d{7,8}$");
		m = p.matcher(phoneCode);
		b = m.matches();
		return b;
	}
	
	/**
	 * 判断电子邮件格式的正确性
	 * @param email 代表电子邮件格式的字符串，如："123@qq.com"
	 * @return true 正确，false 不正确
	 */
	public static boolean isEMail(String email){
		return false;
	}
	
	/**
	 * 判断身份证号码格式的正确性
	 * @param idCard 身份证号码
	 * @return true 正确，false 不正确
	 */
	public static boolean isIdCard(String idCard){
		return false;
	}
	
	/**
	 * 判断不带时间的日期格式的格式正确性
	 * @param date 日期格式字符串
	 * @return true 正确，false 不正确
	 */
	public static boolean isDate(String date){
		return false;
	}
	
	/**
	 * 判断带时间的日期格式的格式正确性
	 * @param dateTime 日期时间格式字符串
	 * @return true 正确，false 不正确
	 */
	public static boolean isDateTime(String dateTime){
		return false;
	}
}
