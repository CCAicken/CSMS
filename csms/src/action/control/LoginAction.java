package action.control;

import java.io.IOException;

import org.apache.struts2.jasper.tagplugins.jstl.core.Out;

import model.TStudent;
import model.TTeacher;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends BaseAction {
	private String userid;
	private String pwd;
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		TStudent stu = userdao.loginStu(userid, pwd);
		if(stu!=null){
			session.setAttribute("loginuser", stu);
			return SUCCESS;
		}
		else{
			TTeacher tea = userdao.loginTea(userid, pwd);
			if(tea!=null){
				session.setAttribute("loginuser", tea);
				return SUCCESS;
			}
		}
		return ERROR;
	}
}