package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.ReturnData;
import model.TForumTitle;
import model.TMajor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.ForumDAO;
import business.dao.MajorDAO;
import business.impl.ForumDAOImpl;

import com.alibaba.fastjson.JSON;

public class getMajorAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Writer out;
		int startPage=0,pageSize=0;
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");
			MajorDAO mdao = ctx.getBean("getMajorDAO",MajorDAO.class);
			out = response.getWriter();
			List<TMajor> list = mdao.select();
			int count = mdao.getPageCount();
			ReturnData rd = new ReturnData();
			rd.code = ReturnData.SUCCESS;
			rd.msg = "³É¹¦";
			rd.count = count;
			rd.data = list;
			out.write(JSON.toJSONString(rd));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}