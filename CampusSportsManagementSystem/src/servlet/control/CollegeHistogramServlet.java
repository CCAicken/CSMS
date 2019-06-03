package servlet.control;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ResponseJSON;

import com.alibaba.fastjson.JSON;

import business.factory.DAOFactory;
import model.College;
import model.ScoreCollege;

/**
 * Servlet implementation class CollegeHistogramServlet
 */
@WebServlet("/collegehistogram.do")
public class CollegeHistogramServlet extends HttpServlet {
    public CollegeHistogramServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		List<ScoreCollege> collegeList = DAOFactory.getScoreCollegeDAO().getAllCollegeScore("all", "all");
		String[][] scoreList = new String[collegeList.size()][3];
		int i=0;
		for(ScoreCollege score : collegeList){
			scoreList[i][0] = score.getCollegename();
			scoreList[i][1] = String.valueOf(score.getScorenumber());
			String color = String.valueOf(getRandColor(200,255));
			scoreList[i][2] = String.valueOf(getRandColor(200,255));
			i++;
		}
		ResponseJSON resj = new ResponseJSON();
		resj.flag = ResponseJSON.FLAG_SUCC;
		String string = scoreList.toString();
		resj.result1 =scoreList.toString();
		out.write(JSON.toJSONString(resj));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 生成随机颜色
	 * @param 颜色rgb最低值
	 * @param 颜色rgb最高值
	 * @return color对象
	 */
	private String getRandColor(int fc,int bc){
		Random random = new Random();
		if(fc>255)
		{
			fc=255;
		}
		if(bc>255)
		{
			bc=255;
		}
		int r = fc+random.nextInt(bc-fc);
		int g = fc+random.nextInt(bc-fc);
		int b = fc+random.nextInt(bc-fc);
		Color color = new Color(r,g,b);
		String R = Integer.toHexString(color.getRed());  
        R = R.length() < 2 ? ('0' + R) : R;  
        String B = Integer.toHexString(color.getBlue());  
        B = B.length() < 2 ? ('0' + B) : B;  
        String G = Integer.toHexString(color.getGreen());  
        G = G.length() < 2 ? ('0' + G) : G;  
        return '#' + R + B + G;  
	}
}
