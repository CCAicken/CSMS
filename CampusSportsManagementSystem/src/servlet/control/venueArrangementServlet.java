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

import util.sendDispatcher;
import business.dao.SceneDAO;
import business.factory.DAOFactory;
import model.Scene;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class venueArrangementServlet
 */
@WebServlet("/venueArrangementServlet.do")
public class venueArrangementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public venueArrangementServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int usertype = (Integer)session.getAttribute("usertype");
		Student student = null;
		Teacher teacher = null;
		if(usertype==1){
			student = (Student)session.getAttribute("loginuser");
		}
		else{
			teacher = (Teacher)session.getAttribute("loginuser");
		}
		
		SceneDAO sdao = DAOFactory.getSceneDAO();
		List<Scene> list = sdao.seleScenes();
		request.setAttribute("scenelist", list);
		for(Scene scene:list){
			System.out.println(scene.getSceneid());
			System.out.println(scene.getArrange().getProject().getProname());
			System.out.println(scene.getArrange().getArrname());
		}
		sendDispatcher.sendUrl("venueArrangement.jsp", request, response);
	}

}
