package action.control;

import java.io.IOException;
import java.io.PrintWriter;

import model.VStudent;
import model.VTeacher;

import common.properties.RoleType;

public class ChangePwdAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		PrintWriter out;
		try {
			out = response.getWriter();
			int usertype = (Integer) session.getAttribute("role");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			String userid = request.getParameter("userid");
			if (usertype == RoleType.Student || usertype == RoleType.Committee) {
				VStudent student = (VStudent) session.getAttribute("loginuser");
				if (!oldpwd.equals(student.getPwd())) {
					out.write("原密码不正确");
					out.flush();
					out.close();
				} else {
					if (userdao.updateStuPwd(userid, newpwd)) {
						VStudent stu = userdao.loginStu(userid, newpwd);
						session.setAttribute("loginuser", stu);
						// student.setPwd(newpwd);
						// session.setAttribute("loginuser", student);
						// session.setAttribute("role", RoleType.Student);
						out.write("修改成功");
						out.flush();
						out.close();
						return SUCCESS;
					} else {
						out.write("修改失败");
						out.flush();
						out.close();
					}
				}
			} else {
				VTeacher teacher = (VTeacher) session.getAttribute("loginuser");
				if (!oldpwd.equals(teacher.getPwd())) {
					out.write("原密码不正确");
					out.flush();
					out.close();
				} else {
					if (userdao.updateTeaPwd(teacher.getUserid(), newpwd)) {
						VTeacher tea = userdao.loginTea(teacher.getUserid(),
								newpwd);
						session.setAttribute("loginuser", tea);
						// teacher.setPwd(newpwd);
						// session.setAttribute("loginuser", teacher);
						// session.setAttribute("role", RoleType.Student);
						// out.print("修改成功");
						out.write("修改成功");
						out.flush();
						out.close();
						return SUCCESS;
					} else {
						// out.print("修改失败");
						out.write("修改失败");
						out.flush();
						out.close();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
}