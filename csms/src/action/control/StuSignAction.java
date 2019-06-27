package action.control;

import java.io.IOException;

import model.TUser;

public class StuSignAction extends BaseAction {

	/**
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException {
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if (op.equals("islogin")) {
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
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}