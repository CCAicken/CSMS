package servlet.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.sendDispatcher;
import business.dao.ArrangeDAO;
import business.factory.DAOFactory;
import model.Arrange;

/**
 * Servlet implementation class ProjectArrangementServlet
 */
@WebServlet("/projectarrangement.do")
public class ProjectArrangementServlet extends HttpServlet {
    public ProjectArrangementServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrangeDAO adao = DAOFactory.getArrangeDAO();
		List<Arrange> arrList = adao.select();
		request.setAttribute("arrList", arrList);
		sendDispatcher.sendUrl("projectArrangement.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
