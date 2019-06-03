package servlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import common.properties.RoleType;
import util.ResponseJSON;
import util.sendDispatcher;
import model.Match;
import model.Project;
import model.Student;
import model.Teacher;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.MatchDAO;
import business.dao.ProjectDAO;
import business.dao.UserDAO;
import business.factory.DAOFactory;

/**
 * Servlet implementation class projectRegistrantionServlet
 */
@WebServlet("/projectregistrantionservlet.do")
public class projectRegistrantionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectRegistrantionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		MatchDAO mdao = DAOFactory.getMatchDAO();

		int usertype = (Integer)session.getAttribute("usertype");//获取用户类型
		String op = request.getParameter("op");
		if(op==null ||op.equals("")) return;
		if(op.equals("add")){
			String proid = request.getParameter("proid");
			System.out.println(proid);
			if(proid!=null&&!proid.equals("")){
				Project project = new Project();
				project.setProid(Integer.parseInt(proid));
				Student student = null;
				Teacher teacher = null;
				Match match = new Match();
				match.setProject(project);
				if(usertype == RoleType.Student){
					student = (Student)session.getAttribute("loginuser");
					boolean issignup = mdao.isSignUp(student.getUserid(), Integer.parseInt(proid));
					if(issignup){
						ResponseJSON resj = new ResponseJSON();
						resj.flag = ResponseJSON.FLAG_FAIL;
						resj.msg ="已报过，请选择其他项目报名";		
						out.write(JSON.toJSONString(resj));
					}else{
						match.setStudent(student);
						match.setRoleid(usertype);
						boolean flag = mdao.insert(match);
						if(flag){
							
							ResponseJSON resj = new ResponseJSON();
							resj.flag = ResponseJSON.FLAG_SUCC;
							resj.msg ="报名成功";
									
							out.write(JSON.toJSONString(resj));
						}else{
							ResponseJSON resj = new ResponseJSON();
							resj.flag = ResponseJSON.FLAG_FAIL;
							resj.msg ="报名失败";
							out.write(JSON.toJSONString(resj));
						}
					}
				}else{
					teacher = (Teacher)session.getAttribute("loginuser");
					boolean issignup = mdao.isSignUp(teacher.getUserid(), Integer.parseInt(proid));
					if(issignup){
						ResponseJSON resj = new ResponseJSON();
						resj.flag = ResponseJSON.FLAG_FAIL;
						resj.msg ="已报过，请选择其他项目报名";		
						out.write(JSON.toJSONString(resj));
					}else{
						match.setTeacher(teacher);
						match.setRoleid(usertype);
						boolean flag = mdao.insert(match);
						if(flag){
							ResponseJSON resj = new ResponseJSON();
							resj.flag = ResponseJSON.FLAG_SUCC;
							resj.msg ="报名成功";
							out.write(JSON.toJSONString(resj));
						}else{
							ResponseJSON resj = new ResponseJSON();
							resj.flag = ResponseJSON.FLAG_FAIL;
							resj.msg ="报名失败";
							out.write(JSON.toJSONString(resj));
						}
					}
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
