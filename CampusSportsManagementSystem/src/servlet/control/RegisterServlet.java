package servlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.sendDispatcher;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.UserDAO;
import business.impl.ClassesDaoImpl;
import business.impl.CollegeDaoImpl;
import business.impl.MajorDaoImpl;
import business.impl.UserDaoImpl;
import common.properties.RoleType;
import model.Classes;
import model.College;
import model.Major;
import model.Role;
import model.Student;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plan;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//获取所有学院信息列表
		CollegeDAO colldao = new CollegeDaoImpl();
		List<College> collegelist = colldao.select();
		if(collegelist==null||collegelist.size()<=0){
			session.setAttribute("collegelist", new ArrayList<College>());
		}else{
			session.setAttribute("collegelist", collegelist);
		}
		String op = request.getParameter("op");
		if(op == null){
			sendDispatcher.sendUrl("register.jsp", request, response);
		}else if(op.equals("college")){
			//学院下拉框改变事件，获取学院相对应的专业信息列表
			String collegeid = request.getParameter("collegeid");
			if(collegeid!=null&&!collegeid.equals("0")&&!collegeid.equals("")){
				MajorDAO mdao = new MajorDaoImpl();
				List<Major> majorlist = mdao.selectByColl(Integer.parseInt(collegeid));
				request.setAttribute("collegeid", collegeid);
				if(majorlist==null||majorlist.size()<=0){
					session.setAttribute("majorlist", new ArrayList<Major>());
				}else{
					int row = majorlist.size();
					session.setAttribute("majorlist", majorlist);
				}
			}else{
				session.setAttribute("majorlist", new ArrayList<Major>());
				session.setAttribute("collegeid", null);
			}
			sendDispatcher.sendUrl("register.jsp", request, response);
		}else if(op.equals("major")){
			//专业下拉框改变事件，获取专业相对应的班级信息列表
			String majorid = request.getParameter("majorid");
			if(majorid!=null&&majorid!=""&&majorid!="0"){
				ClassesDAO classdao = new ClassesDaoImpl();
				List<Classes> classlist = classdao.selectByMajor(Integer.parseInt(majorid));
				request.setAttribute("majorid", majorid);
				if(classlist==null||classlist.size()<=0){
					session.setAttribute("classlist", new ArrayList<Classes>());
				}else{
					session.setAttribute("classlist", classlist);
				}
			}else{
				session.setAttribute("classlist", new ArrayList<Classes>());
				session.setAttribute("majorid", null);
			}
			sendDispatcher.sendUrl("register.jsp", request, response);
		}
		else if(op.equals("add")){
			//提交注册
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String agend = request.getParameter("agend");
			String pwd = request.getParameter("pwd");
			String mobile = request.getParameter("mobile");
			String classid = request.getParameter("classid");
			Student user = new Student();
			user.setUserid(userid);
			user.setUsername(username);
			user.setPwd(pwd);
			user.setAgend(agend);
			user.setMobile(mobile);
			Classes classes = new Classes();
			classes.setClassid(Integer.parseInt(classid));
			user.setClasses(classes);
			UserDAO udao = new UserDaoImpl();
			boolean flag = udao.insertStu(user);
			if(flag){
				out.print("注册成功");
			}else{
				out.print("注册失败");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
