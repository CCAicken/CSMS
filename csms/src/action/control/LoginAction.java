package action.control;

import java.io.IOException;

import javax.servlet.ServletException;

import model.TStudent;
import model.TTeacher;

import common.properties.RoleType;

public class LoginAction extends BaseAction {
	private String userid;
	private String password;
	private String safecode;
	private String errorsText;
	private String backurl;
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getBackurl() {
		return backurl;
	}

	public String getErrorsText() {
		return errorsText;
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
		backurl="login.jsp";
		TStudent stu = userdao.loginStu(userid, password);
		if(stu!=null){
			session.setAttribute("loginuser", stu);
			session.setAttribute("role", RoleType.Student);
			return SUCCESS;
		}
		else{
			TTeacher tea = userdao.loginTea(userid, password);
			if(tea!=null){
				session.setAttribute("loginuser", tea);
				session.setAttribute("role", RoleType.Teacher);
				return SUCCESS;
			}
			else {
				try {
					out.write("µ«¬º ß∞‹£¨«Î÷ÿ ‘");
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return SUCCESS;
		}
		
	}
}