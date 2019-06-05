package action.control;

import java.io.IOException;

import javax.servlet.ServletException;

import model.VStudent;
import model.VTeacher;

public class LoginAction extends BaseAction {
	private String userid;
	private String password;
	private String safecode;

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setSafecode(String safecode) {
		this.safecode = safecode;
	}

	/**
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public String execute() {
		response.setCharacterEncoding("utf-8");
		String sRand = (String) session.getAttribute("rand");
		if (!safecode.toLowerCase().equals(sRand.toLowerCase())) {
			try {
				out.write("验证码不正确");
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			VStudent stu = userdao.loginStu(userid, password);
			if (stu != null) {
				session.setAttribute("loginuser", stu);
				session.setAttribute("role", stu.getRoleid());
				return SUCCESS;
			} else {
				VTeacher tea = userdao.loginTea(userid, password);
				if (tea != null) {
					session.setAttribute("loginuser", tea);
					session.setAttribute("role", tea.getRoleid());
					return SUCCESS;
				}
			}
		}
		return SUCCESS;

	}
}