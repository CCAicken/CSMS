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
import model.Project;
import model.Scene;
import model.Student;
import model.Teacher;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.factory.DAOFactory;

/**
 * Servlet implementation class myProjectServlet
 */
@WebServlet("/myProjectServlet.do")
public class myProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myProjectServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plan;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Student stu = null;
		Teacher tea = null;
		String userid=null;
		int usertype = (Integer)session.getAttribute("usertype");//获取用户类型

		SceneDAO sdao = DAOFactory.getSceneDAO();

		List<Scene> list = null;
		if (usertype == 1) {
			stu = (Student) session.getAttribute("loginuser");
			userid = stu.getUserid();
		} else {
			tea = (Teacher) session.getAttribute("loginuser");
			userid = tea.getUserid();
		}
		list = sdao.seleScenes(userid);
		for (Scene scene : list) {
			System.out.println(scene.getMatch().getProject().getProname());
			System.out.println(scene.getArrange().getProject().getProname());
		}
		List<Project> proList = sdao.seleOtherScenes(userid);
		request.setAttribute("scenelist", list);
		request.setAttribute("proList", proList);
		request.setAttribute("listSize", list.size());
		sendDispatcher.sendUrl("myProject.jsp", request, response);
	}

}
