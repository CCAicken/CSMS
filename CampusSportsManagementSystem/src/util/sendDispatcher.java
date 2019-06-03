package util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 提供RequestDispatcher
 * @author Administrator
 *
 */
public class sendDispatcher {
	/**
	 * 用于调用error.jsp来显示错误信息
	 * @param errorMsg 错误信息
	 * @param backUrl error.jsp中用于返回上一页面的url
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public static void sendError(String errorMsg, String backUrl,
			HttpServletRequest request,HttpServletResponse response) 
					throws IOException,ServletException{
		request.setAttribute("errors", errorMsg);
		request.setAttribute("back", backUrl);
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * 使用分配跳转方式跳转到指定的url地址
	 * @param url 需要跳转的url地址
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public static void sendUrl(String url,
			HttpServletRequest request,HttpServletResponse response) 
					throws IOException,ServletException{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
