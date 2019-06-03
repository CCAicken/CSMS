package servlet.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.sendDispatcher;
import model.College;
import model.Major;
import model.ScoreClasses;
import model.ScoreCollege;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.ScoreClassesDAO;
import business.dao.ScoreCollegeDAO;
import business.factory.DAOFactory;

/**
 * Servlet implementation class ClassachievementServlet
 */
@WebServlet("/classachievement.do")
public class ClassachievementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassachievementServlet() {
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
        
		ScoreClassesDAO scdao=DAOFactory.getScoreClassesDAO();
		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		MajorDAO mdao = DAOFactory.getMajorDAO();
		List<ScoreClasses> scoreclass;
		// 获取班级成绩
		scoreclass=scdao.getAllScoreClasses();
		//获取所有学院、专业
		List<College> collegelist = cdao.select();
		List<Major> majorlist = mdao.select();
		
		request.setAttribute("scoreclass", scoreclass);
		request.setAttribute("collegelist", collegelist);
		request.setAttribute("majorlist", majorlist);
		sendDispatcher.sendUrl("classachievement.jsp", request, response);
	}

}
