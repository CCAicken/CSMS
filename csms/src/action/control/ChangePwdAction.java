package action.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import model.*;
import business.dao.UserDAO;
import business.impl.UserDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

import common.properties.RoleType;

public class ChangePwdAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		PrintWriter out;
		try {
			out = response.getWriter();
			int usertype = (Integer)session.getAttribute("usertype");
			String op = request.getParameter("op");
			if(op.equals("change")){
				String userid = request.getParameter("userid");
				String oldpwd = request.getParameter("oldpwd");
				String newpwd = request.getParameter("newpwd");
				UserDAO udao = new UserDaoImpl();
				if(usertype == RoleType.Student){
					TStudent student = (TStudent)session.getAttribute("loginuser");
					if(!oldpwd.equals(student.getPwd())){
						out.print("原密码不正确");
					}else{
						if(udao.updateStuPwd(userid, newpwd)){
							student.setPwd(newpwd);
							session.setAttribute("loginuser", student);
							out.print("修改成功");
						}else{
							out.print("修改失败");
						}
					}
				}else{
					TTeacher teacher = (TTeacher)session.getAttribute("loginuser");
					if(oldpwd != teacher.getPwd() || !oldpwd.equals(teacher.getPwd())){
						out.print("原密码不正确");
					}else{
						if(udao.updateStuPwd(userid, newpwd)){
							teacher.setPwd(newpwd);
							session.setAttribute("loginuser", teacher);
							out.print("修改成功");
						}else{
							out.print("修改失败");
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}