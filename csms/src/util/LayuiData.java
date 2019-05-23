package util;

import java.util.HashMap;
import java.util.List;


/**
 * 用于储存Layui table加载的json数据格式
 * 
 * @author jock
 *
 */

/**
 * 
 * @author jock
 *public class Layui extends HashMap<String, Object> {
	public static Layui data(Integer count, String msg, List<Object> list) {
		Layui r = new Layui();
		r.put("code", 0);
		r.put("msg", msg);
		r.put("count", count);
		r.put("data", list);
		return r;
	}
}
 */
public class LayuiData {
	public static int SUCCESS=0;
	public static int ERRR=1;
	
	public int code;
	public String  msg;
	public int count;
	public Object data;
	
	public LayuiData(int code, String msg, int count, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public LayuiData() {
		super();
		// TODO Auto-generated constructor stub
	}
}

