package util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ṩRequestDispatcher
 * @author Administrator
 *
 */
public class sendDispatcher {
	/**
	 * ���ڵ���error.jsp����ʾ������Ϣ
	 * @param errorMsg ������Ϣ
	 * @param backUrl error.jsp�����ڷ�����һҳ���url
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
	 * ʹ�÷�����ת��ʽ��ת��ָ����url��ַ
	 * @param url ��Ҫ��ת��url��ַ
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
