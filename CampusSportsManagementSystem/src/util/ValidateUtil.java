package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	/**
	 * �ж��ֻ������ʽ��ȷ��
	 * @param mobile �ֻ�����
	 * @return true ��ȷ��false ����ȷ
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
	 * �ж���ͨ�绰�����ʽ��ȷ��
	 * @param phoneCode ��ͨ�绰���룬������"010-52233298","4725666"
	 * @return true ��ȷ��false ����ȷ
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
	 * �жϵ����ʼ���ʽ����ȷ��
	 * @param email ��������ʼ���ʽ���ַ������磺"123@qq.com"
	 * @return true ��ȷ��false ����ȷ
	 */
	public static boolean isEMail(String email){
		return false;
	}
	
	/**
	 * �ж����֤�����ʽ����ȷ��
	 * @param idCard ���֤����
	 * @return true ��ȷ��false ����ȷ
	 */
	public static boolean isIdCard(String idCard){
		return false;
	}
	
	/**
	 * �жϲ���ʱ������ڸ�ʽ�ĸ�ʽ��ȷ��
	 * @param date ���ڸ�ʽ�ַ���
	 * @return true ��ȷ��false ����ȷ
	 */
	public static boolean isDate(String date){
		return false;
	}
	
	/**
	 * �жϴ�ʱ������ڸ�ʽ�ĸ�ʽ��ȷ��
	 * @param dateTime ����ʱ���ʽ�ַ���
	 * @return true ��ȷ��false ����ȷ
	 */
	public static boolean isDateTime(String dateTime){
		return false;
	}
}
