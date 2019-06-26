package action.control;

import java.io.IOException;

import model.TUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class StuSignAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if (op.equals("add")) {
			// String ds = request.getParameter("datastr");
			String proid = request.getParameter("proid");
			String userinfo = request.getParameter("userinfo");
			JSONArray a = JSON.parseArray(userinfo);
			System.out.println(a.get(0));
		} else if (op.equals("islogin")) {
			TUser user = (TUser) session.getAttribute("loginuser");
			if (user != null) {
				try {
					out.write("已登录");
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					out.write("你还没有登录，报名功能需要登录");
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}