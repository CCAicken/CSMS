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
import business.basic.BaseDao;
import business.dao.*;
import business.factory.DAOFactory;
import business.impl.CollegeDaoImpl;

/**
 * 查看学院成绩的servlet类
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
		int pageSize = 2;
		int pageAmount = 0;
		int currPage = 1;
		if (type != null && type.equals("paging")) {
			currPage = Integer.parseInt(request.getParameter("page"));
			scorecollege = scdao.getAllCollegeScoreBypage("0", pageSize,
					currPage);
			if (scorecollege != null) {
				response.setCharacterEncoding("UTF-8");
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				request.setAttribute("pageAmount", pageAmount);
				String main = ConvertJsonUtils
						.ConvertListToPageJson(scorecollege);
				out.print(main);
				out.flush();
				out.close();
				return;
			}
		} else if (action.equals("search") && (type == null || type.equals(""))) {
			System.out.println("所有");
			// 获取学院成绩
			scorecollege = scdao.getAllCollegeScoreBypage(opretion, pageSize,
					currPage);
			pageAmount = scdao.getpageAmountbysearch(opretion, pageSize);
			if (scorecollege != null) {
				response.setCharacterEncoding("UTF-8");
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				request.setAttribute("pageAmount", pageAmount);
				String main = ConvertJsonUtils
						.ConvertListToPageJson(scorecollege);
				out.print(main);
				out.flush();
				out.close();
				return;
			}
		} else if (action.equals("search") && type.equals("search")) {
			System.out.println("查询");
			if (opretion == null || opretion.equals("")) {
				opretion = "0";
			}
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");

			pageAmount = scdao.getpageAmountbysearch(opretion, pageSize);
			request.setAttribute("pageAmount", pageAmount);
			scorecollege = scdao.getAllCollegeScoreBypage(opretion, pageSize,
					currPage);
			String main = ConvertJsonUtils.ConvertListToPageJson(scorecollege);
			out.print(main);
			out.flush();
			out.close();
			return;
		} else {
			// 获取分页总页数
			pageAmount = scdao.getpageAmount(pageSize);
			// 获取学院成绩
			scorecollege = scdao.getAllCollegeScoreBypage("0", pageSize,
					currPage);
			// 获取所有学院
			List<College> collegelist = cdao.select();
			System.out.println("初始加载");
			request.setAttribute("pageAmount", pageAmount);
			request.setAttribute("collegelist", collegelist);
			request.setAttribute("scorecollege", scorecollege);
			sendDispatcher.sendUrl("collegechievement.jsp", request, response);
		}
	}

}
