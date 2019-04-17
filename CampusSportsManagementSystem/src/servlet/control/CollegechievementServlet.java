package servlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import util.ConvertJsonUtils;
import util.sendDispatcher;
import model.College;
import model.ScoreCollege;
import model.TableBuilder;
import business.basic.BaseDao;
import business.dao.*;
import business.factory.DAOFactory;
import business.impl.CollegeDaoImpl;

/**
 * �鿴ѧԺ�ɼ���servlet��
 */
@WebServlet("/collegechievement.do")
public class CollegechievementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CollegechievementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		ScoreCollegeDAO scdao = DAOFactory.getScoreCollegeDAO();
		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		String action = request.getParameter("action");
		String opretion = request.getParameter("opretion");
		String type = request.getParameter("type");
		List<ScoreCollege> scorecollege = null;
		if (action.equals("search") && (type == null || type.equals(""))) {
			System.out.println("����");
			// ��ȡѧԺ�ɼ�
			scorecollege = scdao.getAllCollegeScoreBypage(opretion);
			if (scorecollege != null) {
				response.setCharacterEncoding("UTF-8");
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				String main = ConvertJsonUtils
						.ConvertListToPageJson(scorecollege);
				out.print(main);
				out.flush();
				out.close();
				return;
			}
		} else if (action.equals("search") && type.equals("search")) {
			System.out.println("��ѯ");
			System.out.println(opretion);
			if(opretion==null||opretion.equals("")){
				opretion="0";
			}
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			scorecollege=scdao.getAllCollegeScoreBypage(opretion);
			String main = ConvertJsonUtils.ConvertListToPageJson(scorecollege);
			out.print(main);
			out.flush();
			out.close();
			return;
		} else {
			// ��ȡѧԺ�ɼ�
			scorecollege = scdao.getAllCollegeScoreBypage("0");
			// ��ȡ����ѧԺ
			List<College> collegelist = cdao.select();
			System.out.println("��ʼ����");
			request.setAttribute("collegelist", collegelist);
			request.setAttribute("scorecollege", scorecollege);
			sendDispatcher.sendUrl("collegechievement.jsp", request, response);
		}
	}

}
