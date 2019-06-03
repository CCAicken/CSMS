package servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.properties.RoleType;
import util.sendDispatcher;
import model.Student;
import model.Teacher;
import business.dao.UserDAO;
import business.factory.DAOFactory;
import business.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plan;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		String sRand = (String)session.getAttribute("rand");
		if(op.equals("login")){
			String userid = request.getParameter("userName");
			String pwd = request.getParameter("pwd");
			//String usertype = request.getParameter("usertype");
			String captcha = request.getParameter("captcha");
			if(!captcha.toLowerCase().equals(sRand.toLowerCase())){
				out.print("ÑéÖ¤Âë´íÎó");
			}else{
				UserDAO udao = DAOFactory.getUserDAO();
				Teacher user = udao.loginTea(userid, pwd);
				if(user!=null&&!user.getUserid().equals("")){
					session.setAttribute("loginuser", user);
					session.setAttribute("usertype", RoleType.Organization);
					out.print("µÇÂ¼³É¹¦");
					//sendDispatcher.sendUrl("main.jsp", request, response);
				}else{
					out.print("µÇÂ¼Ê§°Ü");
				}
//				if(usertype.equals("student")){
//					Student user = udao.loginStu(userid, pwd);
//					if(user!=null&&!user.getUserid().equals("")){
//						session.setAttribute("loginuser", user);
//						session.setAttribute("usertype", RoleType.Student);
//						out.print("µÇÂ¼³É¹¦");
//						//sendDispatcher.sendUrl("main.jsp", request, response);
//					}else{
//						out.print("µÇÂ¼Ê§°Ü");
//					}
//				}else{
//					Teacher user = udao.loginTea(userid, pwd);
//					if(user!=null&&!user.getUserid().equals("")){
//						session.setAttribute("loginuser", user);
//						session.setAttribute("usertype", RoleType.Teacher);
//						out.print("µÇÂ¼³É¹¦");
//						//sendDispatcher.sendUrl("main.jsp", request, response);
//					}else{
//						out.print("µÇÂ¼Ê§°Ü");
//					}
//				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
