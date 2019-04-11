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
import business.dao.ProjectDAO;
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
		response.setContentType("text/plan;charset=utf-8");
		HttpSession session = request.getSession();
		//int usertype = (Integer)session.getAttribute("usertype");//��ȡ�û�����
		int usertype = 1;
		
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		List<Project> projectList = null;
		if(usertype==1 || usertype==2){
			projectList = pdao.selectByType(usertype);//��ʦ��ѧ��ֻ�ܲ鿴�Լ��ܱ�������Ŀ
		}
		else{
			projectList = pdao.select();//��ί����Բ鿴���б�����Ŀ
		}
		request.setAttribute("projectList", projectList);
		sendDispatcher.sendUrl("projectRegistration.jsp", request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
