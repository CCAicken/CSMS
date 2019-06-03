package servlet.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Classes;
import model.College;
import model.Major;
import model.ScoreClasses;
import model.ScoreStudent;
import util.sendDispatcher;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.ScoreClassesDAO;
import business.dao.ScoreStudentDAO;
import business.factory.DAOFactory;

/**
 * Servlet implementation class AllPersonalAchievementServlet
 */
@WebServlet("/allpersonalachievement.do")
public class AllPersonalAchievementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPersonalAchievementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
		ScoreStudentDAO scdao=DAOFactory.getScoreStudentDAO();
		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		MajorDAO mdao = DAOFactory.getMajorDAO();
		ClassesDAO classdao=DAOFactory.getClassesDAO();
		List<ScoreStudent> scorestudent;
		// 获取所有个人成绩
		scorestudent=scdao.getAllScoreStudent();
		//获取所有学院、专业、班级
		List<College> collegelist = cdao.select();
		List<Major> majorlist = mdao.select();
		List<Classes> classlist=classdao.select();
		
		request.setAttribute("scorestudent", scorestudent);
		request.setAttribute("collegelist", collegelist);
		request.setAttribute("majorlist", majorlist);
		request.setAttribute("classlist", classlist);
		
		sendDispatcher.sendUrl("allpersonalachievement.jsp", request, response);
	}

}
