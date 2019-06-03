package util;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 工具类
 * @author Administrator
 *
 */
public class ToolsUtil {
	/**
	 * 日期时间的格式转换，转换后，日期格式为YY-MM-dd HH:mm:SS
	 * @param datetime 时间格式
	 * @return 格式化后的日期格式
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
	 * 格式化时间字符串
	 * @param date 一个包含有完整时间信息的Date类型的对象
	 * @return String 格式化后的字符串，包含日期和时间如："2019-3-15 10:3:12"
	 */
	public static String tranDate2datetime(Date date){
		Format format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = format.format(date);
		return s;
	}
	/**
	 * ：推荐，速度最快 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

}
