package servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import model.Teacher;
import common.properties.RoleType;
import business.dao.UserDAO;
import business.impl.UserDaoImpl;

/**
 * Servlet implementation class ChangePwdServlet
 */
@WebServlet("/changepwd.do")
public class ChangePwdServlet extends HttpServlet {
    public ChangePwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plan;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int usertype = (Integer)session.getAttribute("usertype");
		String op = request.getParameter("op");
		if(op.equals("change")){
			String userid = request.getParameter("userid");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			UserDAO udao = new UserDaoImpl();
			if(usertype == RoleType.Student){
				Student student = (Student)session.getAttribute("loginuser");
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
				Teacher teacher = (Teacher)session.getAttribute("loginuser");
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
