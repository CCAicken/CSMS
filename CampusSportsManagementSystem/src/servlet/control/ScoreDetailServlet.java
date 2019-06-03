package servlet.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.sendDispatcher;
import business.dao.SceneDAO;
import business.dao.ScoreDAO;
import business.factory.DAOFactory;
import model.Classes;
import model.College;
import model.Score;
import model.Student;
import model.Teacher;
import common.properties.RoleType;

/**
 * Servlet implementation class ScoreDetailServlet
 */
@WebServlet("/scoredetail.do")
public class ScoreDetailServlet extends HttpServlet {
    public ScoreDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		String op = request.getParameter("op");
		if(op == null || op.equals("")) return;
		request.setAttribute("op", op);
		String id = request.getParameter("id");
		if(id == null || id.equals("")) return;
		if(op.equals("user")){
			Student student = DAOFactory.getUserDAO().getStudent(id);
			request.setAttribute("user", student);
			List<Score> userScore = sdao.getByUser(id);
			request.setAttribute("scoreList", userScore);
			sendDispatcher.sendUrl("scoreDetail.jsp", request, response);
		}else if(op.equals("college")){
			College college = DAOFactory.getCollegeDAO().selectByid(Integer.parseInt(id));
			request.setAttribute("college", college);
			List<Score> collegeScore = sdao.getByCollege(Integer.parseInt(id));
			request.setAttribute("scoreList", collegeScore);
			sendDispatcher.sendUrl("scoreDetail.jsp", request, response);
		}else if(op.equals("class")){
			Classes classes = DAOFactory.getClassesDAO().selectByid(Integer.parseInt(id));
			request.setAttribute("classes", classes);
			List<Score> classScore = sdao.getByClass(Integer.parseInt(id));
			request.setAttribute("scoreList", classScore);
			sendDispatcher.sendUrl("scoreDetail.jsp", request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
