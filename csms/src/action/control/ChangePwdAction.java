package action.control;

import java.io.IOException;
import java.io.PrintWriter;

import model.TStudent;
import model.TTeacher;

import common.properties.RoleType;

public class ChangePwdAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		PrintWriter out;
		try {
			out = response.getWriter();
			int usertype = (Integer)session.getAttribute("role");
				String oldpwd = request.getParameter("oldpwd");
				String newpwd = request.getParameter("newpwd");
				String userid = request.getParameter("userid");
				if(usertype == RoleType.Student){
					TStudent student = (TStudent)session.getAttribute("loginuser");
					if(!oldpwd.equals(student.getPwd())){
						out.write("ԭ���벻��ȷ");
						out.flush();
						out.close();
					}else{
						if(userdao.updateStuPwd(userid, newpwd)){
							//student.setPwd(newpwd); 
//							session.setAttribute("loginuser", student);
//							session.setAttribute("role", RoleType.Student);
							out.write("�޸ĳɹ�");
							out.flush();
							out.close();
						}else{
							out.write("�޸�ʧ��");
							out.flush();
							out.close();
						}
					}
				}else{
					TTeacher teacher = (TTeacher)session.getAttribute("loginuser");
					if(oldpwd != teacher.getPwd() || !oldpwd.equals(teacher.getPwd())){
						out.write("ԭ���벻��ȷ");
						out.flush();
						out.close();
					}else{
						if(userdao.updateStuPwd(teacher.getUserid(), newpwd)){
							//teacher.setPwd(newpwd);
//							session.setAttribute("loginuser", teacher);
//							session.setAttribute("role", RoleType.Student);
							//out.print("�޸ĳɹ�");
							out.write("�޸ĳɹ�");
							out.flush();
							out.close();
						}else{
							//out.print("�޸�ʧ��");
							out.write("�޸�ʧ��");
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