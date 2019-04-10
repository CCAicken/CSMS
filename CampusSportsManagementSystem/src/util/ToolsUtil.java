package util;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������
 * @author Administrator
 *
 */
public class ToolsUtil {
	/**
	 * ����ʱ��ĸ�ʽת����ת�������ڸ�ʽΪYY-MM-dd HH:mm:SS
	 * @param datetime ʱ���ʽ
	 * @return ��ʽ��������ڸ�ʽ
	 */
	public static String datetimeFormat(String datetime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try{
			date = df.parse(datetime);
			String s = df.format(date);
			return s;
		}catch(Exception e){
			e.printStackTrace();
		}
		return datetime;
	}
	
	/**
	 * ��ʽ��ʱ���ַ���
	 * @param date һ������������ʱ����Ϣ��Date���͵Ķ���
	 * @return String ��ʽ������ַ������������ں�ʱ���磺"2019-3-15 10:3:12"
	 */
	public static String tranDate2datetime(Date date){
		Format format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = format.format(date);
		return s;
	}
}
